/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Travel.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:48
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model.travel

import java.io.Serializable
import team.dahaeng.android.domain.schedule.model.Schedule
import team.dahaeng.android.domain.schedule.model.travel.wrapper.CourseList
import team.dahaeng.android.domain.util.constant.EmptyString

/**
 * 여행지 객체
 *
 * 사용되는 객채([Schedule])에 id 필드([Schedule.id])가 있기 때문에 따로 아이디를 받지 않음
 *
 * 여행지 객체를 사용하는 필드에서 아이디로 갖고 있게 되면
 * source 여행지가 업데이트 됐을 경우 내가 가져와
 * 수정한 여행지에도 source 에서 바뀐게 반영되기 때문에
 * 여행지 객체를 통체로 받음
 * (내가 바꾼 여행 정보를 source 에 영향을
 * 미치지 않게 반영하는 법도 고려해야 하는 문제가 생김)
 *
 * 액티비티 전환할 때 Intent 로 이 객체를 넘겨야 해서
 * 이 객체를 포함한 하위 객체들은 다 Serializable 임
 *
 * 여행지 추가 시나리오
 * 1. 여행 장소인 [Place] 입력 받음
 * 2. 나머지 추가 정보(교통수단, 기간 등등)들 입력 받음
 *
 * @property theme 여행지 테마
 * @property target 여행지 추천 타켓
 * @property commonAddress 여행지의 공통되는 주소 (충청남도 서산시)
 * @property totalPrice 여행지 장소들의 총 금액 (여행지 등록할 때 시스템에서 계산)
 * @property totalPeriod 여행지 장소들의 총 기간 (여행지 등록할 때 시스템에서 계산)
 * @property courses 여행지 방문 코스 리스트 (N 일차)
 */
data class Travel(
    val theme: String = EmptyString,
    val target: String = EmptyString,
    val commonAddress: String = "",
    val totalPrice: Int = 0,
    val totalPeriod: Period = Period(),
    var courses: CourseList = CourseList(),
) : Serializable
