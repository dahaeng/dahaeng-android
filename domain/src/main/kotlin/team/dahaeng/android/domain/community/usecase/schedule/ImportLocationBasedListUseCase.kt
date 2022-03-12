package team.dahaeng.android.domain.community.usecase.schedule

import team.dahaeng.android.domain.community.repository.TourRepository

class ImportLocationBasedListUseCase(private val repository: TourRepository) {
    suspend operator fun invoke(mapX : Double, mapY : Double) = runCatching {
        repository.importLocationBasedList(mapX, mapY)
    }
}