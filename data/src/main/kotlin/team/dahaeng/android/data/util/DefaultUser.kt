/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [DefaultUser.kt] created by Ji Sungbin on 22. 3. 5. 오후 9:52
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.util

import android.graphics.drawable.ColorDrawable
import kotlin.random.Random

internal object DefaultUserConfig {
    val randomColorDrawable get() = ColorDrawable((Math.random() * 16777215).toInt() or (0xFF shl 24))
    val randomNickname get() = "J${Random.nextInt(1000, 10000)}"
}
