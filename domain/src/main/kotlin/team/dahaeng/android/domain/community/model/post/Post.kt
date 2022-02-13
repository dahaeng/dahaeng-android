/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Post.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.post

import team.dahaeng.android.domain.community.model.travel.Travel
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import java.util.Date
import kotlin.random.Random

/**
 * @property id 포스트 UUID
 * @property ownerId 포스트 등록자 UUID
 * @property title 포스트 제목
 * @property content 포스트 내용, HTML 컨텐츠 텍스트 span 한정으로 지원
 * @property travel 포스트에 첨부된 여행 정보
 * @property createdAt 포스트가 업로드된 시간
 * @property photos 포스트의 [Photo] 객체들을
 * [FirebaseRepository.uploadPhotos] 로 업로드 하여 받은 결과 -> 이미지 다운로드 주소 배열
 */
data class Post(
    val id: Long = Random.nextLong(),
    val ownerId: Long = 0L,
    val title: String = "",
    val content: String = "",
    val travel: Travel = Travel(),
    val createdAt: Long = Date().time,
    val photos: List<String> = emptyList(),
)
