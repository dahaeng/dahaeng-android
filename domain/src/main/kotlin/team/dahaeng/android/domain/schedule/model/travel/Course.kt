/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Course.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model.travel

import java.io.Serializable

/**
 * 여행 코스 객체
 *
 * N일차에 여러가지 장소에 갈 수 있으므로 element 를 리스트로 받음
 *
 * Course 는 Map 안에 들어가서 다중 Array 가능
 *
 * @property transportations 여행지 교통편 리스트
 * @property periods 여행지에서 머물 기간 리스트
 * @property places 여행 장소 리스트
 * @property accommodations 머물 숙소 리스트
 */
data class Course(
    val transportations: List<Transportation> = emptyList(),
    val periods: List<Period> = emptyList(),
    val places: List<Place> = emptyList(),
    val accommodations: List<Accommodation> = emptyList(),
) : Serializable
