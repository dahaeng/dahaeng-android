/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Travel.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:48
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

import team.dahaeng.android.domain.community.model.post.Post
import team.dahaeng.android.domain.community.model.schedule.Schedule
import java.io.Serializable

/**
 * 여행지 객체
 * [Post] 와 [Schedule] 에 공통적으로 쓰임
 *
 * 사용되는 객체에 다 id 필드가 있기 때문에 따로 아이디를 받지 않음
 *
 * 일정에도 1일차, 2일차,...,N일차와 같이 단계가 있으므로
 * 단계에 대응하기 위해 [transportations] ~ [accommodations] 는 모두 리스트이며,
 * N일차에 여러가지 장소에 갈 수 있으므로 element 를 list 로 받음
 * N일차마다 정보를 조회할 때 해당 정보 list 의 N-1 번째 index로 접근하여 가져옴
 *
 * 여행지 객체를 사용하는 필드에서 아이디로 갖고 있게 되면
 * source 여행지가 업데이트 됐을 경우 내가 가져와
 * 수정한 여행지에도 source 에서 바뀐게 반영되기 때문에
 * 여행지 객체를 통체로 받음
 * (내가 바꾼 여행 정보를 source 에 영향을
 * 미치지 않게 반영하는 법도 고려해야 하는 문제가 생김)
 *
 * 여행지 추가 시나리오
 * 1. 여행 장소인 [Place] 입력 받음
 * 2. 나머지 추가 정보(교통수단, 기간 등등)들 입력 받음
 *
 * @property theme 여행지 테마
 * @property target 여행지 추천 타켓
 * @property commonAddress 여행지의 공통되는 주소 (충청남도 서산시)
 * @property totalPrice 여행지 장소들 ([places]) 의 총 금액 (여행지 등록할 때 시스템에서 계산)
 * @property totalPeriod 여행지 장소들 ([places]) 의 총 기간 (여행지 등록할 때 시스템에서 계산)
 * @property transportations 여행지 장소들 ([places]) 의 교통편 리스트
 * @property periods 여행지 장소들 ([places]) 의 기간 리스트
 * @property places 여행지 장소 리스트
 * @property accommodations 여행지 장소들 ([places]) 마다 머물 숙소들
 */
data class Travel(
    val theme: Theme = Theme(),
    val target: Target = Target(),
    val commonAddress: String = "",
    val totalPrice: Int = 0,
    val totalPeriod: Period = Period(),
    val courseLists: List<CourseList> = emptyList(),
) : Serializable
