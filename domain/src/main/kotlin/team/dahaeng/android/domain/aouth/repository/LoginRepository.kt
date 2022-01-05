/*
 * Dahaeng © 2021 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginRepository.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:29
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.aouth.repository

import android.content.Context
import team.dahaeng.android.domain.aouth.model.LoginResult

interface LoginRepository {
    suspend fun login(context: Context): LoginResult
}
