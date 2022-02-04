/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [SharedPreferences.kt] created by Ji Sungbin on 22. 1. 18. 오후 6:09
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.extensions

import android.content.SharedPreferences
import androidx.core.content.edit

operator fun SharedPreferences.get(name: String, default: String? = null) = getString(name, default)

operator fun SharedPreferences.set(name: String, value: String) = edit { putString(name, value) }
