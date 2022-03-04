/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Schedule.kt] created by Ji Sungbin on 22. 2. 4. 오전 12:42
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model

import java.io.Serializable
import java.util.Date
import kotlin.random.Random
import team.dahaeng.android.domain.schedule.model.travel.Travel
import team.dahaeng.android.domain.util.constant.EmptyString

/**
 * 일정 객체
 *
 * 일정과 포스트를 공유함
 * 포스트란, 메인 화면에서 보일 아이템 인데
 * 이 아이템들도 결국엔 다 일정으로 만들어진 아이템임
 *
 * 이 아이템을 이용해 본인만의 일정으로 새로 작성하게 된다면 (fork 와 유사)
 * copy 로 [id] 만 바꿔서 재사용 하면 됨
 *
 * @property public 일정 전체 공개 여부
 * @property createdAt 일정이 최종적으로 생성된 시간 (모든 단계를 마침)
 * @property id 일정 UUID
 * @property ownerId 일정 등록자 UUID
 * @property participant 일정 참여자 UUID 리스트
 * @property title 일정 개인 제목
 * @property publicTitle 일정 전체 공개 제목
 * @property content 일정 내용, HTML 컨텐츠 텍스트 span 한정으로 지원
 * @property travel 일정에 첨부된 여행 정보
 * @property forkCount 일정이 쓰인 휫수 (fork된 휫수)
 * @property bookmarkedCount 일정이 북마크된 휫수
 * @property likeCount 일정 좋아요 개수
 * @property hateCount 일정 싫어요 개수
 * @property lastStep 일정 생성 과정에서 마지막으로 머무른 단계의 정보
 */
data class Schedule(
    val public: Boolean = false,
    val createdAt: Long = Date().time,
    val id: Long = Random.nextLong(),
    val ownerId: Long = 0L,
    val participant: List<Long> = emptyList(),
    val title: String = EmptyString,
    val publicTitle: String = EmptyString,
    val content: String = EmptyString,
    val travel: Travel = Travel(),
    val forkCount: Int = 0,
    val bookmarkedCount: Int = 0,
    val likeCount: Int = 0,
    val hateCount: Int = 0,
    val lastStep: LastStep = LastStep(),
) : Serializable
