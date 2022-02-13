package team.dahaeng.android.domain.community.usecase.schedule

import team.dahaeng.android.domain.community.model.Schedule
import team.dahaeng.android.domain.community.repository.FirebaseRepository

class ChangeScheduleUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(schedule: Schedule) = runCatching {
        repository.changeSchedule(schedule)
    }
}