/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginActivity.kt] created by Ji Sungbin on 22. 1. 5. 오후 5:13
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.WindowManager
import android.view.animation.AnticipateInterpolator
import androidx.activity.viewModels
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import dagger.hilt.android.AndroidEntryPoint
import io.github.jisungbin.logeukes.LoggerType
import io.github.jisungbin.logeukes.logeukes
import team.dahaeng.android.BuildConfig
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.activity.base.ResultEvent
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.databinding.ActivityLoginBinding
import team.dahaeng.android.util.extensions.collectWithLifecycle
import team.dahaeng.android.util.extensions.doDelayed
import team.dahaeng.android.util.extensions.toast

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {

    override val vm: LoginViewModel by viewModels()
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        var isReady = false
        doDelayed(1000) {
            isReady = true
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashScreen.setOnExitAnimationListener { splashScreenView ->
                ObjectAnimator.ofFloat(splashScreenView, View.ALPHA, 1f, 0f).run {
                    interpolator = AnticipateInterpolator()
                    duration = 200L
                    doOnEnd { splashScreenView.remove() }
                    start()
                }
            }
        }

        binding.root.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (isReady) {
                        binding.root.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        false
                    }
                }
            }
        )

        vm.eventFlow.collectWithLifecycle(this) { event ->
            when (event) {
                is ResultEvent.Failure -> {
                    logeukes(type = LoggerType.E) { event.exception }
                    toast(getString(R.string.activity_login_toast_login_fail))
                }
                is ResultEvent.Success -> {
                    DataStore.me = event.data
                    toast("로그인 성공!") // TODO: 하드코딩
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
