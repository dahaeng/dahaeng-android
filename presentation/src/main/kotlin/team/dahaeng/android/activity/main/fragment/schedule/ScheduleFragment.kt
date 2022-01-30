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
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseFragment
import team.dahaeng.android.activity.createschedule.CreateScheduleActivity
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.databinding.FragmentScheduleBinding

class ScheduleFragment :
    BaseFragment<FragmentScheduleBinding, MainViewModel>(R.layout.fragment_schedule) {
    override val vm: MainViewModel by activityViewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.rvSchedule.run {
            setHasFixedSize(true)
            setItemViewCacheSize(10)
            adapter = ScheduleAdapter()
            (adapter as ScheduleAdapter).submitList(listOf())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.schedules.collect { scheduleList ->
                    (binding.rvSchedule.adapter as ScheduleAdapter).submitList(scheduleList.toMutableList())
                }
            }
        }

        binding.ibAddSchedule.setOnClickListener {
            startActivity(Intent(context, CreateScheduleActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        vm.importSchedule(DataStore.me.nickname)
    }
}
