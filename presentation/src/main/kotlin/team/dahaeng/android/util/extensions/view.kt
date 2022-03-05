/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [view.kt] created by Ji Sungbin on 22. 3. 6. 오전 12:50
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.extensions

import android.view.View

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide(isGone: Boolean = false) {
    visibility = when (isGone) {
        true -> View.GONE
        else -> View.INVISIBLE
    }
}
