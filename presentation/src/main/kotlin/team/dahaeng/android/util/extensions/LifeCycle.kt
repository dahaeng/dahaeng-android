/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LifeCycle.kt] created by Ji Sungbin on 22. 1. 5. 오후 9:20
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay

fun LifecycleOwner.doDelayed(ms: Long, action: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launchWhenCreated {
        delay(ms)
        action()
    }
}

fun LifecycleOwner.launchedWhenCreated(action: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launchWhenCreated {
        action()
    }
}
