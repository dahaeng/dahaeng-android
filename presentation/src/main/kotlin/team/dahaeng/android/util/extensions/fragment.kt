/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [fragment.kt] created by Ji Sungbin on 22. 3. 6. 오전 12:08
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.extensions

import android.app.Activity
import androidx.fragment.app.Fragment

inline fun <reified T : Activity> Fragment.changeActivityWithAnimation() {
    requireActivity().changeActivityWithAnimation<T>()
}

inline fun <reified T : Activity> Fragment.startActivityWithAnimation() {
    requireActivity().startActivityWithAnimation<T>()
}
