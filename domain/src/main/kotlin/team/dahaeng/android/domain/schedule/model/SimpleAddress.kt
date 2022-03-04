/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [SimpleAddress.kt] created by Ji Sungbin on 22. 3. 4. 오후 8:03
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model

/**
 * @param ciDo 주소에서 시/도에 해당하는 명칭
 * @param gunGu 주소에서 군/구에 해당하는 명칭
 */
data class SimpleAddress(
    val ciDo: String,
    val gunGu: String,
)
