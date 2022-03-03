/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginRepository.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:29
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.aouth.repository

import team.dahaeng.android.domain.aouth.model.User

interface AouthRepository {
    suspend fun kakaoLogin(): User
}
