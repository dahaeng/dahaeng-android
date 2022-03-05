/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [throwable.kt] created by Ji Sungbin on 22. 3. 5. 오후 10:22
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.extensions

import android.content.Context
import team.dahaeng.android.BuildConfig
import team.dahaeng.android.R

fun Throwable.toMessage(context: Context) = when (BuildConfig.DEBUG) {
    true -> message ?: "Unexpected error occured, but exception message is null."
    else -> context.getString(R.string.unexpected_error_occured)
}
