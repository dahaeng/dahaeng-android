package team.dahaeng.android.domain.community.model.tmap.FullTextGeocoding

import com.fasterxml.jackson.annotation.JsonProperty

data class FullTextGeocodingResponse(
    @field:JsonProperty("coordinateInfo")
    val coordinateInfo: CoordinateInfo? = null
)
