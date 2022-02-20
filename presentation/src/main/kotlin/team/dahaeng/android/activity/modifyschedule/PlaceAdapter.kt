/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [PlaceAdapter.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.modifyschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import team.dahaeng.android.databinding.LayoutModifyScheduleBinding

import team.dahaeng.android.domain.community.model.travel.Course

class PlaceAdapter :
    ListAdapter<Course, PlaceAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutModifyScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: LayoutModifyScheduleBinding,
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(course : Course) {
            binding.period = "" + course.period.to + "~" + course.period.from
            binding.place = course.place
        }
    }


    override fun getItemCount() = currentList.count()

    private companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Course>() {
            override fun areContentsTheSame(oldItem: Course, newItem: Course) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Course, newItem: Course) =
                oldItem == newItem
        }
    }
}
