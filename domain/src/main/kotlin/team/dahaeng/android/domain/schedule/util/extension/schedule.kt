/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [schedule.kt] created by Ji Sungbin on 22. 3. 5. 오후 11:57
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.util.extension

import team.dahaeng.android.domain.schedule.model.Schedule

/**
 * [Schedule] 모델에 바로 작성 하면 추후 Firestore 에 올라갈 때 다 같이 올라감
 */

/**
 * 일정 썸네일 사진 추출 및 다운로드 링크 반환
 *
 * @return 일정의 첫 번째 여행지 사진의 링크
 * 만약 올라온 이미지가 없다면 null
 */
fun Schedule.getThumbnailImageOrNull(): String? {
    return travel.getFirstImageOrNull()
}

/**
 * 여행지 레이팅(점수) 반환
 *
 * @return 5점 만점의 레이팅 점수
 */
fun Schedule.geRating(): Float {
    // TODO
    return 2.5f
}
