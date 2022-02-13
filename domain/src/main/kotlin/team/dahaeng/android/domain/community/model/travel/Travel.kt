/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Travel.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:48
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

import team.dahaeng.android.domain.community.model.common.Photo
import team.dahaeng.android.domain.community.repository.FirebaseRepository

/**
 * 여행지 객체
 *
 * 사용되는 객체에 다 id 필드가 있기 때문에 따로 아이디를 받지 않음
 *
 * @property commonAddress 공통되는 주소
 * @property photos 포스트의 [Photo] 객체들을
 * [FirebaseRepository.uploadPhotos] 로 업로드 하여 받은 결과 -> 이미지 다운로드 주소 배열
 */
data class Travel(
    val price: Long = 0, // 가격
    val locate: Locate = Locate(),
    val transportation: Transportation = Transportation(), // 교통 수단
    val period: Period = Period(), // 기간
    val places: List<Place> = emptyList(), // 여행지 목록
    val photos: List<String> = emptyList(), // 여행지 사진
    val theme: Theme = Theme(), // 태그
    val target: Target = Target(), // 추천 대상
    val rating: Float = 0f, // 평점, 최대 5점
)
