/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ImageViewAdapter.kt] created by Ji Sungbin on 22. 1. 19. 오후 2:06
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.ui.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.loadAny
import team.dahaeng.android.R

@BindingAdapter("with_glide_small")
fun loadSrcWithGlideSmallSize(view: ImageView, src: Any) {
    // GlideApp.with(view).load(src).format(DecodeFormat.PREFER_RGB_565).into(view)
    view.loadAny(src) {
        crossfade(true)
        placeholder(R.drawable.ic_round_airplane_ticket_24)
        // transformations(CircleCropTransformation())
    }
}

@BindingAdapter("with_glide_big")
fun loadSrcWithGlideBigSize(view: ImageView, src: Any) {
    // GlideApp.with(view).load(src).format(DecodeFormat.PREFER_ARGB_8888).into(view)
    view.loadAny(src) {
        crossfade(true)
        placeholder(R.drawable.ic_round_airplane_ticket_24)
        // transformations(CircleCropTransformation())
    }
}
