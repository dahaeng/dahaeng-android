package team.dahaeng.android.domain.schedule.usecase

import team.dahaeng.android.domain.community.repository.FirebaseRepository

class ImportScheduleUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(id: String) = runCatching {
        repository.importSchedules(id)
    }
}