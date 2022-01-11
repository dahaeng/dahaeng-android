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
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.suspendCancellableCoroutine
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import team.dahaeng.android.domain.community.model.Post
import java.text.SimpleDateFormat
import java.util.*

class FirebaseRepositoryImpl : FirebaseRepository {

    private val storage = Firebase.storage
    private val storageRef = storage.reference
    override fun uploadImage(uri: Uri) {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.KOREA).format(Date())
        val imgFileName = "IMAGE_" + timeStamp + "_.png"
        storageRef.child("image").child(imgFileName)
        storageRef.putFile(uri).addOnSuccessListener {
            Log.i("UPLOAD FIREBASE", "SUCCESS")
        }
    }

    override suspend fun importPost(): List<Post> =
        suspendCancellableCoroutine { continuation ->
            val postList = mutableListOf<Post>()
            Firebase.firestore.collection("test0103")
                .get()
                .addOnSuccessListener {  result ->
                    for(document in result){
                        val post = document.toObject<Post>()
                        postList.add(post)
                    }
                    continuation.resume(postList, null)
                }
                .addOnFailureListener { exception ->
                    continuation.resume(listOf(), null)
                }
        }

    override fun importImages() {
//        storageRef.child("image/IMAGE_20220104_103538_.png").downloadUrl.addOnSuccessListener { Uri ->
//            Glide.with(this)
//                .load(Uri)
//                .into(binding.imageviewCommunity)
    }

}