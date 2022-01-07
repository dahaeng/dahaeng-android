/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [FirebaseRepositoryImpl.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.aouth.repository

import android.net.Uri
import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import team.dahaeng.android.domain.aouth.repository.FirebaseRepository
import java.text.SimpleDateFormat
import java.util.*

class FirebaseRepositoryImpl : FirebaseRepository {

    private val storage = Firebase.storage

    override suspend fun uploadImage(uri : Uri) {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.KOREA).format(Date())
        val imgFileName = "IMAGE_" + timeStamp + "_.png"
        val storageRef = storage.reference.child("image").child(imgFileName)
        storageRef.putFile(uri!!).addOnSuccessListener {
            Log.i("UPLOAD FIREBASE", "SUCCESS")
        }
    }

}