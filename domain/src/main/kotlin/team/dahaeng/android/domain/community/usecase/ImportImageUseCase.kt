package team.dahaeng.android.domain.community.usecase

import team.dahaeng.android.domain.community.repository.FirebaseRepository

class ImportImageUseCase(private val repository: FirebaseRepository) {

    operator fun invoke() {
        repository.importImages()
    }

}