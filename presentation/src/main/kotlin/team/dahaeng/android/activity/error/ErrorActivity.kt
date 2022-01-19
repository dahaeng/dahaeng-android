/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ErrorActivity.kt] created by Ji Sungbin on 22. 1. 19. 오후 12:05
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.error

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import io.github.jisungbin.erratum.ErratumExceptionActivity
import team.dahaeng.android.R
import team.dahaeng.android.databinding.ActivityErrorBinding

class ErrorActivity : ErratumExceptionActivity() {

    private lateinit var binding: ActivityErrorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_error)
        val message =
    }
}
