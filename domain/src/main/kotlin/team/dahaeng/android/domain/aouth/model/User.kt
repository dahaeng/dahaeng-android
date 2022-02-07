/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [User.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:01
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.aouth.model

import android.graphics.drawable.ColorDrawable
import kotlin.random.Random

// profileImageUrl: String or ColorDrawable
data class User(val id: Long, val nickname: String, val profileImageUrl: Any) {
    companion object {
        private val randomColor get() = (Math.random() * 16777215).toInt() or (0xFF shl 24)
        fun getDefaultNickname() = "사용자${Random.nextInt(1000, 10000)}"
        fun getDefaultProfileImageColor() = ColorDrawable(randomColor)
    }
}
