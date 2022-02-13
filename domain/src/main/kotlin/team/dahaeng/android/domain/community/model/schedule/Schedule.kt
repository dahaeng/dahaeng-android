/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Schedule.kt] created by Ji Sungbin on 22. 2. 4. 오전 12:42
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.schedule

import team.dahaeng.android.domain.community.model.common.Photo
import team.dahaeng.android.domain.community.model.travel.Accommodation
import team.dahaeng.android.domain.community.model.travel.Period
import team.dahaeng.android.domain.community.model.travel.Place
import team.dahaeng.android.domain.community.model.travel.Theme
import team.dahaeng.android.domain.community.model.travel.Transportation
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import kotlin.random.Random

/**
 * 일정 객체
 *
 * 일정에도 1일차, 2일차,...,N일차와 같이 단계가 있으므로
 * 단계에 대응하기 위해 [transportations] ~ [accommodations] 는 모두 리스트이며,
 * 모두 사이즈가 같아야 하기에 쓰이지 않는 요소는 null 값을 넣어서 사이즈를 맞춰줘야 함
 * (개별 단계별로 쓰이지 않는 요소도 있을 수 있기 때문에
 * 리스트 필드는 모두 nullable element를 가지고 있음)
 *
 * 여행지 객체를 아이디로 갖고 있게 되면
 * source 여행지가 업데이트 됐을 경우 내가 일정으로 가져와
 * 수정한 여행지에도 source 에서 바뀐게 반영되기 때문에
 * 여행지 객체를 통체로 받음
 * (내가 바꾼 여행 정보를 source 에 영향을
 * 미치지 않게 반영하는 법도 고려해야 하는 문제가 생김)
 *
 * @property id 일정 UUID
 * @property participant 일정 참여자 UUID 리스트, <b>첫 요소는 무조건 해당 일정의 owner 임</b>
 * @property title 일정 제목
 * @property theme 일정 테마
 * @property totalPrice 일정 총 금액
 * @property totalPeriod 일정 총 기간
 * @property transportations 일정동안 쓰일 교통편 리스트
 * @property periods 일정의 기간 리스트
 * @property photos 일정의 [Photo] 객체들을
 * [FirebaseRepository.uploadPhotos] 로 업로드 하여 받은 결과 -> 이미지 다운로드 주소 배열
 * @property places 일정에 속한 모든 여행지 목록
 * @property accommodations 일정동안 머물 숙소들
 */
data class Schedule(
    val id: Long = Random.nextLong(),
    val participant: List<Long> = emptyList(),
    val title: String = "",
    val theme: Theme = Theme(),
    val totalPrice: Long = 0,
    val totalPeriod: Period = Period(),
    val transportations: List<Transportation?> = emptyList(),
    val periods: List<Period?> = emptyList(),
    val photos: List<String> = emptyList(),
    val places: List<Place> = emptyList(),
    val accommodations: List<Accommodation?> = emptyList(),
)
