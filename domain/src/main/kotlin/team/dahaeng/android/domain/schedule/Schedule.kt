package team.dahaeng.android.domain.schedule

import team.dahaeng.android.domain.community.model.travel.*

data class Schedule(
    val title : String = "no title",
    val theme: Theme = Theme.None, // 테마
    val totalPrice: Long = 0, // 총 가격
    val transportation: Transportation = Transportation.None, // 교통 수단
    val period: Period = Period.None, // 기간
    val photos: List<String> = emptyList(), // 여행지 사진
    val places: List<Place> = emptyList(), // 여행지 목록
    val accommodation : String = "" // 숙소
)
