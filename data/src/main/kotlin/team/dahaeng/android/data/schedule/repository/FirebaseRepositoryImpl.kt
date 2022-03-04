/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [FirebaseRepositoryImpl.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.schedule.repository

import android.graphics.Bitmap
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlinx.coroutines.suspendCancellableCoroutine
import team.dahaeng.android.data.util.Constants
import team.dahaeng.android.data.util.toObjectNonNull
import team.dahaeng.android.domain.schedule.model.Photo
import team.dahaeng.android.domain.schedule.model.Schedule
import team.dahaeng.android.domain.schedule.model.SimpleAddress
import team.dahaeng.android.domain.schedule.repository.FirebaseRepository

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

    private fun FirebaseFirestore.setSchedulePath(address: SimpleAddress) =
        collection(Constants.Firestore.Schedule)
            .document(address.ciDo)
            .collection(address.gunGu)

    private fun FirebaseFirestore.setSchedulePath(
        address: SimpleAddress,
        scheduleId: Long,
    ) = collection(Constants.Firestore.Schedule)
        .document(address.ciDo)
        .collection(address.gunGu)
        .document(scheduleId.toString())

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
            .child(Constants.Storage.Photo)
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

    override suspend fun importSchedulesFromUser(
        address: SimpleAddress,
        userId: Long,
    ): List<Schedule> = suspendCancellableCoroutine { continuation ->
        firestore
            .setSchedulePath(address = address)
            .whereEqualTo("ownerId", userId)
            .get()
            .addOnSuccessListener { result ->
                continuation.resume(result.documents.map(DocumentSnapshot::toObjectNonNull))
            }
            .addOnFailureListener { exception ->
                continuation.resumeWithException(exception)
            }
    }

    override suspend fun importAllSchedules(address: SimpleAddress): List<Schedule> =
        suspendCancellableCoroutine { continuation ->
            firestore
                .setSchedulePath(address = address)
                .get()
                .addOnSuccessListener { result ->
                    continuation.resume(result.documents.map(DocumentSnapshot::toObjectNonNull))
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }

    override suspend fun uploadSchedule(
        address: SimpleAddress,
        schedule: Schedule,
    ) = suspendCancellableCoroutine<Unit> { continuation ->
        firestore
            .setSchedulePath(
                address = address,
                scheduleId = schedule.id
            )
            .set(schedule)
            .addOnSuccessListener {
                continuation.resume(Unit)
            }
            .addOnFailureListener { exception ->
                continuation.resumeWithException(exception)
            }
    }

    override suspend fun deleteSchedule(
        address: SimpleAddress,
        scheduleId: Long,
    ) = suspendCancellableCoroutine<Unit> { continuation ->
        firestore
            .setSchedulePath(
                address = address,
                scheduleId = scheduleId
            )
            .delete()
            .addOnSuccessListener {
                continuation.resume(Unit)
            }
            .addOnFailureListener { exception ->
                continuation.resumeWithException(exception)
            }
    }
}
