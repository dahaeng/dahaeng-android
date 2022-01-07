/*
 * Dahaeng © 2022 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [FirebaseRepository.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.aouth.repository

import android.net.Uri

interface FirebaseRepository {
    suspend fun uploadImage(uri : Uri)
}