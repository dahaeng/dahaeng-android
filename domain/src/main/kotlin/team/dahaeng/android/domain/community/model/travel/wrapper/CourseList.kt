/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [CourseList.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel.wrapper

import team.dahaeng.android.domain.community.model.travel.Course
import java.io.Serializable

/**
 * [Course] 리스트
 *
 * Firestore 에 중첩 배열 업로드가 안되서 CourseList 따로 생성
 * data class 는 Map 으로 저장되고,
 * Map -> Array, Array, Array 는 됨
 * 하지만 Array -> Array 는 안됨
 * 따라서 Array -> Array 를 하기 위해선 중간에 Map 으로 Wrapping 을 해야 함
 *
 * 일정에도 1일차, 2일차,...,N일차와 같이 단계가 있으므로
 * 단계에 대응하기 위해 Course 를 리스트로 받음
 * N일차마다 정보를 조회할 때 해당 정보 리스트의 N-1 번째 index로 접근하여 가져옴
 */
data class CourseList(
    val courses: List<Course> = emptyList(),
) : Serializable
