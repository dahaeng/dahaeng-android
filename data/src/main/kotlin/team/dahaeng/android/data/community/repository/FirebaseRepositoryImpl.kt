/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [FirebaseRepositoryImpl.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.community.repository

import android.net.Uri
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.suspendCancellableCoroutine
import team.dahaeng.android.data.util.Constants
import team.dahaeng.android.data.util.toObjectNonNull
import team.dahaeng.android.domain.community.model.Post
import team.dahaeng.android.domain.community.model.Schedule
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import kotlin.coroutines.resume

private const val UPLOAD_IMAGE_EXCEPTION = "이미지 업로드중 에러"

class FirebaseRepositoryImpl : FirebaseRepository {

    private val firestore by lazy { Firebase.firestore }
    private val storageRef by lazy { Firebase.storage.reference }

    /**
     * @return 성공시 이미지 주소, 실패시 null
     */
    override suspend fun uploadImage(uri: Uri, imageName: String): String? =
        suspendCancellableCoroutine { continuation ->
            storageRef.child(Constants.Firestore.Post).run {
                child(imageName)
                    .putFile(uri)
                    .continueWithTask { task ->
                        if (!task.isSuccessful && task.exception != null) {
                            continuation.resume(null)
                            throw task.exception!!
                        }
                        downloadUrl
                    }.addOnCompleteListener { task ->
                        if (task.isSuccessful && task.result != null) {
                            continuation.resume(task.result!!.toString())
                        } else {
                            continuation.resume(null)
                            throw task.exception ?: Exception(UPLOAD_IMAGE_EXCEPTION)
                        }
                    }
            }
        }

    /**
     * @return 성공 여부 boolean
     */
    override suspend fun uploadPost(post: Post): Boolean =
        suspendCancellableCoroutine { continuation ->
            firestore.collection(Constants.Firestore.Post)
                .document(post.id.toString())
                .set(post)
                .addOnSuccessListener {
                    continuation.resume(true)
                }.addOnFailureListener { exception ->
                    continuation.resume(false)
                    throw exception
                }
        }

    /**
     * 전체 포스트 조회
     */
    override suspend fun importPosts(): List<Post> =
        suspendCancellableCoroutine { continuation ->
            firestore.collection(Constants.Firestore.Post)
                .get()
                .addOnSuccessListener { result ->
                    continuation.resume(result.documents.map(DocumentSnapshot::toObjectNonNull))
                }
                .addOnFailureListener { exception ->
                    continuation.resume(emptyList())
                    throw exception
                }
        }

    /**
     * 내 스케줄 리스트 조회
     */
    override suspend fun importSchedules(ownerId: Long): List<Schedule> =
        suspendCancellableCoroutine { continuation ->
            firestore.collection(Constants.Firestore.User)
                .document(ownerId.toString())
                .collection(Constants.Firestore.Schedule)
                .get()
                .addOnSuccessListener { result ->
                    continuation.resume(result.documents.map(DocumentSnapshot::toObjectNonNull))
                }
                .addOnFailureListener { exception ->
                    continuation.resume(emptyList())
                    throw exception
                }
        }

    /**
     * 일정 업로드
     *  @return 성공 여부 boolean
     */
    override suspend fun uploadSchedule(schedule: Schedule): Boolean =
        suspendCancellableCoroutine { continuation ->
            firestore.collection(Constants.Firestore.User)
                .document(schedule.participant.first().toString())
                .collection(Constants.Firestore.Schedule)
                .document(schedule.id.toString())
                .set(schedule)
                .addOnSuccessListener {
                    continuation.resume(true)
                }
                .addOnFailureListener { exception ->
                    continuation.resume(false)
                    throw exception
                }
        }

    /**
     * 일정 삭제
     *  @return 성공 여부 boolean
     */
    override suspend fun deleteSchedule(schedule: Schedule): Boolean =
        suspendCancellableCoroutine { continuation ->
            firestore.collection(Constants.Firestore.User)
                .document(schedule.participant.first().toString())
                .collection(Constants.Firestore.Schedule)
                .document(schedule.id.toString())
                .delete()
                .addOnSuccessListener {
                    continuation.resume(true)
                }
                .addOnFailureListener { exception ->
                    continuation.resume(false)
                    throw exception
                }
        }
}
