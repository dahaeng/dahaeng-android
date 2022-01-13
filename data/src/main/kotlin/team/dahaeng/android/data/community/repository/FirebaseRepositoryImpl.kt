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
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageException
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.handleCoroutineException
import kotlinx.coroutines.suspendCancellableCoroutine
import team.dahaeng.android.domain.community.model.Post
import team.dahaeng.android.domain.community.repository.FirebaseRepository

class FirebaseRepositoryImpl : FirebaseRepository {

    // private val storage = Firebase.storage
    // private val storageRef = storage.reference
    private val store = Firebase.firestore
    override fun uploadImage(uri: Uri, imgFileName: String) {

        val storage = Firebase.storage
        val storageRef = storage.reference
        storageRef.child("image").child(imgFileName).putFile(uri).addOnSuccessListener {
            Log.i("UPLOAD FIREBASE", "SUCCESS")
        }.addOnFailureListener { exception ->
            val errorCode = (exception as StorageException).errorCode
            val errorMessage = exception.message
            Log.i("UPLOAD FAIL errorcode", errorCode.toString())
            Log.i("UPLOAD FAIL errormessage", errorMessage.toString())
        }
    }

    override fun uploadPost(post: Post) {
        store.collection("test0103").document().set(post).addOnSuccessListener {
            Log.i("UPLOAD STORE", "SUCCESS")
        }.addOnFailureListener {
            Log.i("UPLOAD STORE", "FAIL")
        }
    }

    override suspend fun importPost(): List<Post> =
        suspendCancellableCoroutine { continuation ->
            val postList = mutableListOf<Post>()
            store.collection("test0103")
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