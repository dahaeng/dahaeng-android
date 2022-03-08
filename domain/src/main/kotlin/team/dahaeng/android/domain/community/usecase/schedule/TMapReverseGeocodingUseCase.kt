package team.dahaeng.android.domain.community.usecase.schedule

import team.dahaeng.android.domain.community.repository.TMapRepository

class TMapReverseGeocodingUseCase(private val repository: TMapRepository) {
    suspend operator fun invoke(lat : Long, lon : Long) = runCatching {
        repository.getReverseGeocodingData(lat, lon)
    }
}