package team.dahaeng.android.domain.community.model.tmap.FullTextGeocoding

import com.fasterxml.jackson.annotation.JsonProperty


data class CoordinateInfo(

    @field:JsonProperty("coordType")
    val coordType: String? = null,

    @field:JsonProperty("addressFlag")
    val addressFlag: String? = null,

    @field:JsonProperty("coordinate")
    val coordinate: List<CoordinateItem?>? = null,

    @field:JsonProperty("count")
    val count: String? = null,

    @field:JsonProperty("page")
    val page: String? = null,

    @field:JsonProperty("totalCount")
    val totalCount: String? = null
)