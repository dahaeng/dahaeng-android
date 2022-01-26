/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Store.kt] created by Ji Sungbin on 22. 1. 13. 오후 7:51
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data

import team.dahaeng.android.domain.aouth.model.User
import team.dahaeng.android.domain.community.model.Post
import team.dahaeng.android.domain.schedule.Schedule

// TODO: 이게 맞나?? ㅋㅋ
@Suppress("ObjectPropertyName")
object DataStore {
    lateinit var me: User

    private val _posts = mutableListOf<Post>()
    val posts: List<Post> get() = _posts

    private val _schedules = mutableListOf<Schedule>()
    val schedules: List<Schedule> get() = _schedules

    fun updatePosts(posts: List<Post>) {
        _posts.addAll(posts)
    }

    fun updateSchedules(schedules: List<Schedule>){
        _schedules.addAll(schedules)
    }
}
