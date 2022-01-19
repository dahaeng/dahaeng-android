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
import team.dahaeng.android.GlideApp

@BindingAdapter("with_glide_small")
fun loadSrcWithGlide(view: ImageView, src: Any) {
    GlideApp.with(view).load(src).override(100).into(view)
}
