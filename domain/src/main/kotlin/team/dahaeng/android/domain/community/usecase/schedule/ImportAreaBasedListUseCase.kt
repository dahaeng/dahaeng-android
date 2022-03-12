package team.dahaeng.android.domain.community.usecase.schedule

import team.dahaeng.android.domain.community.repository.TourRepository

class ImportAreaBasedListUseCase(private val repository: TourRepository) {
    suspend operator fun invoke() = runCatching {
        repository.importAreaBasedList()
    }
}