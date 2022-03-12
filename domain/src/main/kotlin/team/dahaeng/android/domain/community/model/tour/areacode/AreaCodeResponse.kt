package team.dahaeng.android.domain.community.model.tour.areacode

import com.fasterxml.jackson.annotation.JsonProperty

data class AreaCodeResponse(
    @field:JsonProperty("response")
    val response: Response? = null,
)
