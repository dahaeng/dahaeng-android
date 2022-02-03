/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Flow.kt] created by Ji Sungbin on 22. 1. 13. 오후 8:20
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow

fun <T> Flow<T>.collectWithLifecycle(
    lifecycleOwner: LifecycleOwner,
    action: suspend (T) -> Unit,
) {
    lifecycleOwner.lifecycleScope.launchWhenCreated {
        flowWithLifecycle(lifecycleOwner.lifecycle).collect { value ->
            action(value)
        }
    }
}
