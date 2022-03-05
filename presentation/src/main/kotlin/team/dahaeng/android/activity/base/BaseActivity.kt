/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
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
import io.github.jisungbin.logeukes.LoggerType
import io.github.jisungbin.logeukes.logeukes
import team.dahaeng.android.util.extensions.collectWithLifecycle
import team.dahaeng.android.util.extensions.toMessage
import team.dahaeng.android.util.extensions.toast

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutId: Int,
) : AppCompatActivity() {

    abstract val vm: VM
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this

        vm.exceptionFlow.collectWithLifecycle(this) { exception ->
            logeukes(type = LoggerType.E) { exception }
            toast(exception.toMessage(applicationContext))
        }
    }
}
