/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [CreateScheduleActivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.createschedule

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.databinding.ActivityCreateScheduleBinding
import team.dahaeng.android.domain.community.model.schedule.Schedule
import team.dahaeng.android.domain.community.model.travel.*
import team.dahaeng.android.domain.community.model.travel.Target

@AndroidEntryPoint
class CreateScheduleActivity : BaseActivity<ActivityCreateScheduleBinding, MainViewModel>(
    R.layout.activity_create_schedule
) {
    override val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnCreateScheduleComplete.setOnClickListener {
            vm.addSchedule(
                testSchedule()
            )

            finish()
        }
    }

    private fun testSchedule() : Schedule {
        return Schedule(
            travel = Travel(
                courseLists = listOf(
                    CourseList(
                        courses = listOf(
                            Course(
                                transportation = Transportation(
                                    name = "항공"
                                )
                            ),
                            Course(
                                transportation = Transportation(
                                    name = "배"
                                )
                            )
                        )
                    ),
                    CourseList(
                        courses = listOf(
                            Course(
                                transportation = Transportation(
                                    name = "항공"
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}
