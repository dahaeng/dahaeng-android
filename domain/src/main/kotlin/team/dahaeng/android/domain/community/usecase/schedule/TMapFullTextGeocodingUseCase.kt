package team.dahaeng.android.domain.community.usecase.schedule

import team.dahaeng.android.domain.community.repository.TMapRepository

class TMapFullTextGeocodingUseCase(private val repository: TMapRepository) {
    suspend operator fun invoke(address : String) = runCatching {
        repository.getFullTextGeocodingData(address)
    }
}