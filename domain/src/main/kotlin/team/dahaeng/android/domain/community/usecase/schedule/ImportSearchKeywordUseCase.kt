package team.dahaeng.android.domain.community.usecase.schedule

import team.dahaeng.android.domain.community.repository.TourRepository

class ImportSearchKeywordUseCase(private val repository: TourRepository) {
    suspend operator fun invoke(keyword :String) = runCatching {
        repository.importSearchKeyword(keyword)
    }
}