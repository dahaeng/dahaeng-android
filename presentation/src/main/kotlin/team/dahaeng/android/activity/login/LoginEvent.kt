/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginEvent.kt] created by Ji Sungbin on 22. 1. 6. 오전 3:05
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import team.dahaeng.android.activity.base.BaseEvent
import team.dahaeng.android.domain.aouth.model.User

sealed class LoginEvent : BaseEvent {
    object Failure : LoginEvent()
    data class Success(val user: User) : LoginEvent()
}
