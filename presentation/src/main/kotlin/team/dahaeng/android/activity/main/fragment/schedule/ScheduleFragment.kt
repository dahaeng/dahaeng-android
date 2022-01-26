/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [TaskingFragment.kt] created by Ji Sungbin on 22. 1. 17. 오전 9:56
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.main.fragment.schedule

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseFragment
import team.dahaeng.android.activity.createschedule.CreateScheduleActivity
import team.dahaeng.android.activity.main.MainActivity
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.activity.tasking.TaskingActivity
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.databinding.FragmentScheduleBinding
import team.dahaeng.android.domain.community.model.travel.Theme

class ScheduleFragment :
    BaseFragment<FragmentScheduleBinding, MainViewModel>(R.layout.fragment_schedule) {
    override val vm: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSchedule.run {
            setHasFixedSize(true)
            setItemViewCacheSize(10)
            adapter = ScheduleAdapter()
        }

        lifecycle.coroutineScope.launch {
            vm.schedules.collect { scheduleList ->
                if (scheduleList.isNotEmpty()) {
                        (binding.rvSchedule.adapter as ScheduleAdapter).submitList(scheduleList) // TODO: Fix - fragment를 처음 실행할땐 표시가 안됨
                }
            }
        }

        binding.ibAddSchedule.setOnClickListener {
            startActivity(Intent(context, CreateScheduleActivity::class.java))
        }

    }
}
