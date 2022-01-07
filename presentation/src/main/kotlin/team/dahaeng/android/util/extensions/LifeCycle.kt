/*
 * Dahaeng © 2022 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LifeCycle.kt] created by Ji Sungbin on 22. 1. 5. 오후 9:20
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay

fun LifecycleOwner.doDelayed(ms: Long, action: suspend () -> Unit) {
    lifecycleScope.launchWhenCreated {
        delay(ms)
        action()
    }
}
