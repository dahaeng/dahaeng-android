/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Schedule.kt] created by Ji Sungbin on 22. 2. 13. 오후 4:16
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Schedule.kt] created by Ji Sungbin on 22. 2. 4. 오전 12:42
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.schedule

import team.dahaeng.android.domain.community.model.post.Photo
import team.dahaeng.android.domain.community.model.travel.Period
import team.dahaeng.android.domain.community.model.travel.Place
import team.dahaeng.android.domain.community.model.travel.Theme
import team.dahaeng.android.domain.community.model.travel.Transportation
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import kotlin.random.Random
import team.dahaeng.android.domain.community.model.travel.Accommodation

/**
 * @property id 일정 UUID
 * @property participant 일정 참여자 UUID 리스트, <b>첫 요소는 무조건 해당 일정의 owner 임</b>
 * @property title 일정 제목
 * @property theme 일정 테마
 * @property totalPrice 일정동안 예상된 총 금액
 * @property transportation 일정동안 쓰일 교통편
 * @property period 일정의 총 기간
 * @property photos 일정의 [Photo] 객체들을
 * [FirebaseRepository.uploadPhotos] 로 업로드 하여 받은 결과 -> 이미지 다운로드 주소 배열
 * @property places 일정에 속한 모든 여행지 목록
 * @property accommodation 일정동안 머물 숙소
 */
data class Schedule(
    val id: Long = Random.nextLong(),
    val participant: List<Long> = emptyList(),
    val title: String = "",
    val theme: String = Theme.None.value, // 테마
    val totalPrice: Long = 0, // 총 가격
    val transportation: String = Transportation.None.value, // 교통 수단
    val period: Period = Period(), // 기간
    val photos: List<String> = emptyList(), // 여행지 사진
    val places: List<Place> = emptyList(), // 여행지 목록
    val accommodation: Accommodation = , // 숙소
)
