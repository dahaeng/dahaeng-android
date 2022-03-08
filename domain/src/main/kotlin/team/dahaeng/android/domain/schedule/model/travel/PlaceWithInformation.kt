/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [PlaceCourse.kt] created by Ji Sungbin on 22. 3. 8. 오후 9:00
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model.travel

import team.dahaeng.android.domain.schedule.model.travel.wrapper.TransportationList

/**
 * [Place] 와 그에 해당하는 기타 정보들을 같이 모아둔 객체
 *
 * 한 곳의 장소를 들리면서 여러 교통수단을 탈 수 있으므로
 * [transportations] 를 리스트로 받음
 *
 * PlaceWithInformation 은 Array 안에 들어가서 Array 불가능
 *
 * @property place 여행 장소
 * @property period [place] 에서 머물 기간
 * @property accommodation 머물 숙소
 * @property transportations [place] 에 가기 위한 교통편 리스트
 */
data class PlaceWithInformation(
    val place: Place = Place(),
    val period: Period = Period(),
    val accommodation: Accommodation = Accommodation(),
    val transportations: TransportationList = TransportationList(),
)
