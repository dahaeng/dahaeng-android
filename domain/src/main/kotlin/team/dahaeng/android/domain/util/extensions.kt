/*
 * Dahaeng © 2021 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [extensions.kt] created by Ji Sungbin on 22. 1. 6. 오전 2:04
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.util

suspend fun <T> suspendRun(block: suspend () -> T) = block()
