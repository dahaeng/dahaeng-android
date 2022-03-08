/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Place.kt] created by Ji Sungbin on 22. 1. 13. 오후 7:01
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model.travel

import java.io.Serializable
import team.dahaeng.android.domain.schedule.model.travel.wrapper.PhotoList
import team.dahaeng.android.domain.util.constant.EmptyString

/**
 * 장소 객체
 *
 * 어느 상황에서나 공통되는 정보들로만 구성함
 * 교통수단이나 기간 등은 매 상황마다 달라질 수 있는 정보임
 *
 * Place 는 Array 안에 들어가서 Array 를 내부에서 사용할 수 없음
 * 따라서 [photos] 를 [PhotoList] 로 받음
 *
 * @property mainPrice 대표되는 금액 (식당이면 대표 메뉴 금액)
 * @property name 장소 이름
 * @property description 장소 설명
 * @property locate 장소 위치
 * @property photos 장소 사진 리스트
 */
data class Place(
    val mainPrice: Int = 0,
    val name: String = EmptyString,
    val description: String = EmptyString,
    val locate: Locate = Locate(),
    val photos: PhotoList = PhotoList(),
) : Serializable
