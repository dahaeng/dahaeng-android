/*
    created by 210202
    Usage:

    ex) MainActivity

    class MainActivity : BaseActivity<ActivityMainBinding>(
     R.layout.activity_main
    ) {

    }
 */
package team.dahaeng.android.activity.base

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding>(
    layoutRes: Int
) : AppCompatActivity(layoutRes) {

    val binding by lazy {
        DataBindingUtil.bind<B>(
            (window.decorView.findViewById(android.R.id.content) as ViewGroup).getChildAt(0)
        )!!
    }


}