/*
 * Dahaeng © 2022 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [BaseActivity.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:48
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel>(@LayoutRes private val layoutId: Int) :
    AppCompatActivity() {

    abstract val vm: VM
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        with(binding) {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.vm, vm)
        }
    }
}
