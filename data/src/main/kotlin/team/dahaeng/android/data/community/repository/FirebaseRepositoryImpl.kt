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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.suspendCancellableCoroutine
import team.dahaeng.android.domain.community.model.Post
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import kotlin.coroutines.resume

class FirebaseRepositoryImpl : FirebaseRepository {

    private val firestore by lazy { Firebase.firestore }
    private val storageRef by lazy { Firebase.storage.reference }

    override suspend fun uploadImage(uri: Uri, imgFileName: String): Unit =
        suspendCancellableCoroutine { continuation ->
            storageRef.child("image")
                .child(imgFileName)
                .putFile(uri)
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }.addOnFailureListener { exception ->
                    throw exception
                }
        }

    override suspend fun uploadPost(post: Post): Unit =
        suspendCancellableCoroutine { continuation ->
            firestore.collection("test0103")
                .document()
                .set(post)
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }.addOnFailureListener { exception ->
                    throw exception
                }
        }

    override suspend fun importPost(): List<Post> =
        suspendCancellableCoroutine { continuation ->
            val postList = mutableListOf<Post>()
            firestore.collection("test0103")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        val post = document.toObject<Post>()
                        postList.add(post)
                    }
                    continuation.resume(postList, null)
                }
                .addOnFailureListener { exception ->
                    continuation.resume(listOf(), null)
                }
        }
}
