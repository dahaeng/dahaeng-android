/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginActivity.kt] created by Ji Sungbin on 22. 1. 5. 오후 5:13
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.BuildConfig
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityLoginBinding
import team.dahaeng.android.util.extensions.toast

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {

    override val vm: LoginViewModel by viewModels()
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        lifecycleScope.launchWhenCreated {
            vm.eventFlow.flowWithLifecycle(lifecycle).collect { event ->
                when (event) {
                    is LoginEvent.Failure -> toast(getString(R.string.activity_login_toast_login_fail))
                    is LoginEvent.Success -> {
                        toast("로그인 성공!")
                    }
                }
            }
        }
    }

    private fun initExoPlayer() {
        player = ExoPlayer.Builder(this)
            .build()
            .apply {
                repeatMode = Player.REPEAT_MODE_ONE
            }
            .also { player ->
                val video = MediaItem.fromUri(BuildConfig.LOGIN_INTRO_VIDEO_URI)
                player.setMediaItem(video)
                binding.exoPlayer.player = player
            }

        player!!.playWhenReady = true
        player!!.prepare()
    }

    private fun releaseExoPlayer() {
        player?.release()
        player = null
    }

    override fun onStart() {
        super.onStart()
        initExoPlayer()
    }

    override fun onStop() {
        super.onStop()
        releaseExoPlayer()
    }
}
