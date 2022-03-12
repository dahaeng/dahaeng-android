package team.dahaeng.android.domain.community.model.tour.catergorycode

import com.fasterxml.jackson.annotation.JsonProperty
import team.dahaeng.android.domain.community.model.tour.catergorycode.Response

data class CategoryCodeResponse(
    @field:JsonProperty("response")
    val response: Response? = null,
)
