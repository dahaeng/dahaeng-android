package team.dahaeng.android.domain.schedule.usecase

import team.dahaeng.android.domain.community.repository.FirebaseRepository
import team.dahaeng.android.domain.schedule.model.Schedule

class UploadScheduleUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(schedule: Schedule, id: String) = runCatching {
        repository.uploadSchedule(schedule, id)
    }
}
