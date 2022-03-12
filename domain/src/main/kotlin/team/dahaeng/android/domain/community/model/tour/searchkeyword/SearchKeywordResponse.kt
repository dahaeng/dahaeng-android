package team.dahaeng.android.domain.community.model.tour.searchkeyword

import com.fasterxml.jackson.annotation.JsonProperty

data class SearchKeywordResponse(
    @field:JsonProperty("response")
    val response: Response? = null,
)