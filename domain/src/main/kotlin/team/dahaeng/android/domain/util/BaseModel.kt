/*
 * Dahaeng © 2022 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [BaseModel.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:47
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.util

interface BaseModel {
    val exception: Throwable?
    fun isFailure() = exception != null
}
