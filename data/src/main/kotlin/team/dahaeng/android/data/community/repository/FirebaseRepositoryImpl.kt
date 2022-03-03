/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [FirebaseRepositoryImpl.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.community.repository

import android.graphics.Bitmap
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.suspendCancellableCoroutine
import team.dahaeng.android.data.util.Constants
import team.dahaeng.android.data.util.toObjectNonNull
import team.dahaeng.android.domain.community.model.common.Photo
import team.dahaeng.android.domain.community.model.post.Post
import team.dahaeng.android.domain.community.model.schedule.Schedule
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import java.io.ByteArrayOutputStream
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

private const val UPLOAD_IMAGE_EXCEPTION = "이미지 업로드중 에러"

class FirebaseRepositoryImpl : FirebaseRepository {

    private val firestore by lazy { Firebase.firestore }
    private val storageRef by lazy { Firebase.storage.reference }

    private fun StorageReference.setPhotoPath(
        parentPath: String,
        photoName: String,
    ): StorageReference {
        var reference = this
        parentPath.split("/").forEach { subPath ->
            reference = reference.child(subPath)
        }
        return reference.child("$photoName.jpg")
    }

    private fun Bitmap.toByeArray(): ByteArray {
        val baos = ByteArrayOutputStream()
        compress(Bitmap.CompressFormat.JPEG, 100, baos)
        return baos.toByteArray()
    }

    private suspend fun updatePhoto(
        photo: Photo,
        parentPath: String,
        exceptionHandler: (exception: Exception) -> Unit,
    ): String? = suspendCancellableCoroutine { continuation ->
        storageRef
            .child(Constants.Firestore.Post)
            .run {
                setPhotoPath(
                    parentPath = parentPath,
                    photoName = photo.name
                ).putBytes(photo.bitmap.toByeArray())
                    .continueWithTask {
                        downloadUrl
                    }.addOnCompleteListener { task ->
                        if (task.isSuccessful && task.result != null) {
                            continuation.resume(task.result.toString())
                        } else {
                            val exception = task.exception ?: Exception(UPLOAD_IMAGE_EXCEPTION)
                            exceptionHandler(exception)
                            continuation.resume(null)
                        }
                    }
            }
    }

    override suspend fun uploadPhotos(
        photos: List<Photo>,
        parentPath: String,
        exceptionHandler: (exception: Exception) -> Unit,
    ) = photos.map { photo ->
        updatePhoto(
            photo = photo,
            parentPath = parentPath,
            exceptionHandler = exceptionHandler
        )
    }

    override suspend fun uploadPost(post: Post) {
        suspendCancellableCoroutine<Unit> { continuation ->
            firestore
                .collection(Constants.Firestore.Post)
                .document(post.id.toString())
                .set(post)
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }.addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }

    override suspend fun importAllPosts(): List<Post> =
        suspendCancellableCoroutine { continuation ->
            firestore
                .collection(Constants.Firestore.Post)
                .get()
                .addOnSuccessListener { result ->
                    continuation.resume(result.documents.map(DocumentSnapshot::toObjectNonNull))
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }

    override suspend fun deletePost(postId: Long) {
        suspendCancellableCoroutine<Unit> { continuation ->
            firestore
                .collection(Constants.Firestore.Post)
                .document(postId.toString())
                .delete()
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }.addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }

    override suspend fun importSchedules(userId: Long): List<Schedule> =
        suspendCancellableCoroutine { continuation ->
            firestore
                .collection(Constants.Firestore.User)
                .document(userId.toString())
                .collection(Constants.Firestore.Schedule)
                .get()
                .addOnSuccessListener { result ->
                    continuation.resume(result.documents.map(DocumentSnapshot::toObjectNonNull))
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }

    override suspend fun uploadSchedule(schedule: Schedule) =
        suspendCancellableCoroutine<Unit> { continuation ->
            firestore.collection(Constants.Firestore.User)
                .document(
                    schedule.participant.firstOrNull()?.toString()
                        ?: throw IllegalArgumentException("schedule.participant is empty.")
                )
                .collection(Constants.Firestore.Schedule)
                .document(schedule.id.toString())
                .set(schedule)
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }

    override suspend fun deleteSchedule(userId: Long, scheduleId: Long) =
        suspendCancellableCoroutine<Unit> { continuation ->
            firestore.collection(Constants.Firestore.User)
                .document(userId.toString())
                .collection(Constants.Firestore.Schedule)
                .document(scheduleId.toString())
                .delete()
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
}
