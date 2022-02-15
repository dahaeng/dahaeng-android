/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Place.kt] created by Ji Sungbin on 22. 1. 13. 오후 7:01
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

import team.dahaeng.android.domain.community.model.common.Photo
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import java.io.Serializable

/**
 * 장소 객체
 *
 * 어느 상황에서나 공통되는 정보들로만 구성함
 * 교통수단이나 기간 등은 매 상황마다 달라질 수 있는 정보임
 *
 * @property mainPrice 대표되는 금액 (식당이면 대표 메뉴 금액)
 * @property name 장소 이름
 * @property locate 장소 위치
 * @property photos 장소의 사진들인 [Photo] 객체들을
 * [FirebaseRepository.uploadPhotos] 로 업로드 하여 받은 결과 -> 이미지 다운로드 주소 배열
 */
data class Place(
    val mainPrice: Int = 0,
    val name: String = "",
    val locate: Locate = Locate(),
    val photos: List<String> = emptyList(),
) : Serializable
