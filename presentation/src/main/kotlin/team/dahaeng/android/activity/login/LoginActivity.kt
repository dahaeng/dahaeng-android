/*
 * Dahaeng © 2021 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginActivity.kt] created by Ji Sungbin on 22. 1. 5. 오후 5:13
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import androidx.activity.viewModels
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityLoginBinding
import team.dahaeng.android.secret.Resources

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {

    override val vm: LoginViewModel by viewModels()

    private var player: ExoPlayer? = null

    private fun initExoPlayer() {
        player = ExoPlayer.Builder(this)
            .build()
            .also { player ->
                val video = MediaItem.fromUri(Resources.Intro)
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
