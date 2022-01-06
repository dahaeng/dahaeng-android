package team.dahaeng.android.domain.aouth.repository

import android.net.Uri

interface FirebaseRepository {
    suspend fun uploadImage(uri : Uri)
}