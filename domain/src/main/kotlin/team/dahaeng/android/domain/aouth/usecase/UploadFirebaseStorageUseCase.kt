package team.dahaeng.android.domain.aouth.usecase

import android.net.Uri
import team.dahaeng.android.domain.aouth.repository.FirebaseRepository

class UploadFirebaseStorageUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(uri: Uri) = try {
        repository.uploadImage(uri)
    } catch (exception: Exception){
        // upload fail exception
    }
}