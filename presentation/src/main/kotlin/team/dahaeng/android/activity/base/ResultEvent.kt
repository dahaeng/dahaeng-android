/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ResultEvent.kt] created by Ji Sungbin on 22. 1. 6. 오전 3:05
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.base

sealed class ResultEvent<out T> : BaseEvent {
    data class Success<out T>(val data: T) : ResultEvent<T>()
    data class Failure(val exception: Throwable) : ResultEvent<Nothing>()
}
