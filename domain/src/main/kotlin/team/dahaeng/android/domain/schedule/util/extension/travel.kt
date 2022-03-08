/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [travel.kt] created by Ji Sungbin on 22. 3. 8. 오후 8:06
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.util.extension

import team.dahaeng.android.domain.schedule.model.travel.Travel

/**
 * 일정의 첫 번째 여행지 사진 다운로드 링크 반환
 *
 * @return 일정의 첫 번째 여행지 사진의 링크
 * 만약 올라온 이미지가 없다면 null
 */
fun Travel.getFirstImageOrNull(): String? {
    return courses
        .firstOrNull()?.courses
        ?.firstOrNull()?.places
        ?.firstOrNull()?.photos
        ?.urls?.firstOrNull()
}
