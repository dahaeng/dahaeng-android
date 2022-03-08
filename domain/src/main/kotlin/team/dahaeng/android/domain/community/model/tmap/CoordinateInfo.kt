package team.dahaeng.android.domain.community.model.tmap


data class CoordinateInfo(
    val page : String,
    val count : String,
    val totalCount : String,
    val coordinate: List<Coordinate>,
)
