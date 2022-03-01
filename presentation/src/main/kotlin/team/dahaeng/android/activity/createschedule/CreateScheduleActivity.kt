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

    private fun testSchedule(): Schedule {
        return Schedule(
            title = binding.textInputEditText.text.toString(),
            travel = Travel(
                theme = Theme(),
                commonAddress = "공통 주소",
                totalPrice = 1000000,
                totalPeriod = Period(
                    to = 20220221,
                    from = 20220225
                ),
                courseLists = listOf(
                    CourseList(
                        courses = listOf(
                            Course(
                                transportation = Transportation(
                                    name = "항공"
                                ),
                                period = Period(
                                    to = 20220221,
                                    from = 20220222
                                ),
                                place = Place(
                                    mainPrice = 10000,
                                    name = "장소 이름",
                                    locate = Locate(),
                                    photos = listOf("사진들")
                                ),
                                accommodation = Accommodation(
                                    name = "호텔",
                                    locate = Locate(),
                                ),
                            ),

                            Course(
                                transportation = Transportation(
                                    name = "배"
                                ),
                                period = Period(
                                    to = 20220222,
                                    from = 20220223
                                ),
                                place = Place(
                                    mainPrice = 20000,
                                    name = "장소 이름",
                                    locate = Locate(),
                                    photos = listOf("사진들")
                                ),
                                accommodation = Accommodation(
                                    name = "펜션",
                                    locate = Locate(),
                                ),
                            ),
                        )
                    ),
                    CourseList(
                        courses = listOf(
                            Course(
                                transportation = Transportation(
                                    name = "항공"
                                ),
                                period = Period(
                                    to = 20220223,
                                    from = 20220224
                                ),
                                place = Place(
                                    mainPrice = 30000,
                                    name = "장소 이름",
                                    locate = Locate(),
                                    photos = listOf("사진들")
                                ),
                                accommodation = Accommodation(
                                    name = "호텔",
                                    locate = Locate(),
                                ),
                            ),

                            Course(
                                transportation = Transportation(
                                    name = "배"
                                ),
                                period = Period(
                                    to = 20220224,
                                    from = 20220225
                                ),
                                place = Place(
                                    mainPrice = 40000,
                                    name = "장소 이름",
                                    locate = Locate(),
                                    photos = listOf("사진들")
                                ),
                                accommodation = Accommodation(
                                    name = "펜션",
                                    locate = Locate(),
                                ),
                            ),
                        )
                    )
                )
            )
        )
    }
}
