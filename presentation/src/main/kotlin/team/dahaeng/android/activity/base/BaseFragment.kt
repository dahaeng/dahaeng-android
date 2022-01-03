/*
    created by 210202
    Usage:

    ex) MainFragment

    class MainFragment : BaseFragment<FragmentMainBinding>(
     R.layout.fragment_main
    ) {

    }
 */

package team.dahaeng.android.activity.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding>(
    layoutRes: Int
) : Fragment(layoutRes) {

    private lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.bind(view!!)!!
        return view
    }
}