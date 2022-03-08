/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [date.kt] created by Ji Sungbin on 22. 3. 8. 오후 10:20
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.util.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal fun Date.format(format: String) = SimpleDateFormat(format, Locale.KOREA).format(this)
