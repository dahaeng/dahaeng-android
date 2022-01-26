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
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.suspendCancellableCoroutine
import team.dahaeng.android.data.util.Constants
import team.dahaeng.android.data.util.toObjectNonNull
import team.dahaeng.android.domain.community.model.Post
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import team.dahaeng.android.domain.schedule.Schedule
import kotlin.coroutines.resume

class FirebaseRepositoryImpl : FirebaseRepository {

    private val firestore by lazy { Firebase.firestore }
    private val storageRef by lazy { Firebase.storage.reference }

    override suspend fun uploadImage(uri: Uri, imageName: String): Unit =
        suspendCancellableCoroutine { continuation ->
            storageRef.child(Constants.Firestore.Post)
                .child(imageName)
                .putFile(uri)
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }.addOnFailureListener { exception ->
                    throw exception
                }
        }

    override suspend fun uploadPost(post: Post): Unit =
        suspendCancellableCoroutine { continuation ->
            firestore.collection(Constants.Firestore.Post)
                .document(post.id.toString())
                .set(post)
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }.addOnFailureListener { exception ->
                    throw exception
                }
        }

    override suspend fun importPosts(): List<Post> = suspendCancellableCoroutine { continuation ->
        firestore.collection(Constants.Firestore.Post)
            .get()
            .addOnSuccessListener { result ->

                continuation.resume(result.documents.map(DocumentSnapshot::toObjectNonNull))
            }
            .addOnFailureListener { exception ->
                throw exception
            }
    }

    override suspend fun importSchedules(id : String): List<Schedule> =
        suspendCancellableCoroutine { continuation ->
            firestore.collection(Constants.Firestore.Schedule) // 컬렉션 이름
                .document(id) // 문서 이름
                .collection("0126")
                .get()
                .addOnSuccessListener { result ->
                    continuation.resume(result.documents.map(DocumentSnapshot::toObjectNonNull))
                }
                .addOnFailureListener { exception ->
                    throw exception
                }

        }


    override suspend fun uploadSchedule(schedule: Schedule, id: String): Unit =
        suspendCancellableCoroutine { continuation ->
            firestore.collection(Constants.Firestore.Schedule)
                .document(id) // id별로 폴더 나눠서 업로드
                .collection("0126")
                .document()
                .set(schedule)
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }
                .addOnFailureListener { exception ->
                    throw exception
                }
        }
}