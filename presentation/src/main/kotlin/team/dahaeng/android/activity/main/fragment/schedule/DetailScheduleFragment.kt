package team.dahaeng.android.activity.main.fragment.schedule

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseFragment
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.databinding.FragmentDeatilScheduleBinding

class DetailScheduleFragment : BaseFragment<FragmentDeatilScheduleBinding, MainViewModel>(
    R.layout.fragment_deatil_schedule
){
    override val vm: MainViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}