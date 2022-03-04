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
import io.github.jisungbin.logeukes.LoggerType
import io.github.jisungbin.logeukes.logeukes
import team.dahaeng.android.BuildConfig
import team.dahaeng.android.R
import team.dahaeng.android.databinding.ActivityErrorBinding
import team.dahaeng.android.util.constants.Key

// TODO: firebase crashlytics
class ErrorActivity : ErratumExceptionActivity() {

    private lateinit var binding: ActivityErrorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_error)
        binding.lifecycleOwner = this

        when (intent.getStringExtra(Key.Intent.Error)) {
            Key.Intent.NoInternet -> {
                binding.lavLottie.run {
                    setAnimation(R.raw.no_internet)
                    repeatCount = 100
                }
                binding.tvException.text = getString(R.string.activity_error_no_internet)
            }
            else -> { // Key.Intent.Exception
                binding.lavLottie.run {
                    setAnimation(R.raw.request_fail)
                    setOnClickListener {
                        playAnimation()
                    }
                }
                binding.tvException.text = if (BuildConfig.DEBUG) {
                    logeukes(type = LoggerType.E) { exceptionString }
                    exceptionString
                } else {
                    getString(R.string.activity_error_exception)
                }
            }
        }

        binding.btnRestart.setOnClickListener {
            openLastActivity()
        }
    }
}
