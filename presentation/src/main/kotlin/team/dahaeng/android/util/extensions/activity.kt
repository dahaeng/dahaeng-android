/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [activity.kt] created by Ji Sungbin on 22. 3. 4. 오후 2:37
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.extensions

import android.app.Activity
import android.content.Intent

inline fun <reified T : Activity> Activity.changeActivityWithAnimation() {
    startActivityWithAnimation<T>()
    finish()
}

inline fun <reified T : Activity> Activity.startActivityWithAnimation() {
    startActivity(Intent(this, T::class.java))
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}
