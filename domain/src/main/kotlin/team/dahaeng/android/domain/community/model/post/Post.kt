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
import team.dahaeng.android.domain.util.constant.EmptyString
import java.util.Date
import kotlin.random.Random

/**
 * 여행지 추천 게시글 객체
 *
 * 사진은 [travel] 에 포함되므로 따로 입력받지 않음
 *
 * @property id 포스트 UUID
 * @property ownerId 포스트 등록자 UUID
 * @property title 포스트 제목
 * @property content 포스트 내용, HTML 컨텐츠 텍스트 span 한정으로 지원
 * @property travel 포스트에 첨부된 여행 정보
 * @property createdAt 포스트가 업로드된 시간
 */
data class Post(
    val id: Long = Random.nextLong(),
    val ownerId: Long = 0L,
    val title: String = EmptyString,
    val content: String = EmptyString,
    val travel: Travel = Travel(),
    val createdAt: Date = Date(),
)
