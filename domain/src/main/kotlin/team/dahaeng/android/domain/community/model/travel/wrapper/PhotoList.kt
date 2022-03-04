/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [PhotoList.kt] created by Ji Sungbin on 22. 3. 4. 오후 4:23
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel.wrapper

import team.dahaeng.android.domain.community.model.common.Photo
import team.dahaeng.android.domain.community.repository.FirebaseRepository

/**
 * 이미지 링크 리스트
 *
 * @property urls 장소의 사진들인 [Photo] 객체들을
 * [FirebaseRepository.uploadPhotos] 로 업로드 하여 받은 결과 -> 이미지 다운로드 주소 배열
 */
data class PhotoList(
    val urls: List<String> = emptyList(),
)
