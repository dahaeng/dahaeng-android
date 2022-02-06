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
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseFragment
import team.dahaeng.android.activity.createschedule.CreateScheduleActivity
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.databinding.FragmentScheduleBinding
import team.dahaeng.android.util.extensions.collectWithLifecycle

class ScheduleFragment : BaseFragment<FragmentScheduleBinding, MainViewModel>(
    R.layout.fragment_schedule
) {

    private val adapter by lazy { ScheduleAdapter() }
    override val vm: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSchedule.run {
            setHasFixedSize(true)
            setItemViewCacheSize(10)
            adapter = this@ScheduleFragment.adapter.apply {
                submitList(emptyList())
            }
        }

        vm.schedules.collectWithLifecycle(viewLifecycleOwner) { scheduleList ->
            adapter.submitList(scheduleList)
        }

        binding.ibAddSchedule.setOnClickListener {
            startActivity(Intent(context, CreateScheduleActivity::class.java))
        }
    }
}
