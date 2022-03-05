/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoadState.kt] created by Ji Sungbin on 22. 3. 6. 오전 12:26
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.constant

sealed class LoadState<out T> {
    object Loading : LoadState<Nothing>()
    object Empty : LoadState<Nothing>()
    data class Done<T>(val value: T) : LoadState<T>()
}
