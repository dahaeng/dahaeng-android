/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginActivity.kt] created by Ji Sungbin on 22. 1. 5. 오후 5:13
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.WindowManager
import android.view.animation.AnticipateInterpolator
import androidx.activity.viewModels
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
import team.dahaeng.android.activity.error.ErrorActivity
import team.dahaeng.android.activity.main.MainActivity
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.databinding.ActivityLoginBinding
import team.dahaeng.android.domain.aouth.model.User
import team.dahaeng.android.util.NetworkUtil
import team.dahaeng.android.util.constants.Key
import team.dahaeng.android.util.extensions.collectWithLifecycle
import team.dahaeng.android.util.extensions.get
import team.dahaeng.android.util.extensions.set
import team.dahaeng.android.util.extensions.toJsonString
import team.dahaeng.android.util.extensions.toModel
import team.dahaeng.android.util.extensions.toast
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {

    override val vm: LoginViewModel by viewModels()
    private var player: ExoPlayer? = null
    private var isReady = false

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        if (!NetworkUtil.isNetworkAvailable(applicationContext)) {
            finish()
            startActivity(
                Intent(this, ErrorActivity::class.java).apply {
                    putExtra(Key.Intent.Error, Key.Intent.NoInternet)
                }
            )
            return
        }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        vm.importPostsWithDoneAction { posts ->
            DataStore.updatePosts(posts)
            if (sharedPreferences[Key.User.KakaoProfile] != null) {
                // 자동 로그인 상태
                val me = sharedPreferences[Key.User.KakaoProfile]!!.toModel<User>()
                DataStore.me = me
                logeukes {
                    listOf(
                        "자동 로그인됨",
                        me,
                        posts
                    )
                }
                startMainActivity()
            } else {
                isReady = true
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashScreen.setOnExitAnimationListener { splashScreenView ->
                splashScreenView.animate().run {
                    alpha(0f)
                    scaleX(0f)
                    scaleY(0f)
                    interpolator = AnticipateInterpolator()
                    duration = 200L
                    withEndAction { splashScreenView.remove() }
                    withLayer()
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
                    toast(getString(R.string.activity_login_toast_start_fail))
                }
                is ResultEvent.Success -> {
                    DataStore.me = event.data
                    toast(getString(R.string.activity_login_toast_welcome))
                    startMainActivity()
                    sharedPreferences[Key.User.KakaoProfile] = event.data.toJsonString()
                }
            }
        }
    }

    // TODO: 플리커가 왜 생기지??
    private fun playbackStateListener() = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            when (playbackState) {
                ExoPlayer.STATE_BUFFERING, ExoPlayer.STATE_IDLE -> {
                    binding.exoPlayer.visibility = View.GONE
                    binding.ivIntroThumbnail.visibility = View.VISIBLE
                }
                ExoPlayer.STATE_READY -> {
                    binding.exoPlayer.visibility = View.VISIBLE
                    binding.ivIntroThumbnail.visibility = View.GONE
                }
                ExoPlayer.STATE_ENDED -> {}
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

        player!!.addListener(playbackStateListener())
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

    private fun startMainActivity() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }
}
