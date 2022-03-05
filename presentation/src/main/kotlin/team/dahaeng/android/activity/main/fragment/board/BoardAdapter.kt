/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [PostAdapter.kt] created by Ji Sungbin on 22. 1. 19. 오후 4:28
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.main.fragment.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import team.dahaeng.android.databinding.LayoutSchedulePostBinding
import team.dahaeng.android.domain.schedule.model.Schedule

class BoardAdapter(
    private val onScheduleClick: (schedule: Schedule) -> Unit,
) : ListAdapter<Schedule, BoardAdapter.BoardViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val binding =
            LayoutSchedulePostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(binding, onScheduleClick)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BoardViewHolder(
        private val binding: LayoutSchedulePostBinding,
        private val onScheduleClick: (schedule: Schedule) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(schedule: Schedule) {
            binding.run {
                this.schedule = schedule
                root.setOnClickListener {
                    onScheduleClick(schedule)
                }
            }
        }
    }

    override fun getItemId(position: Int) = getItem(position).id

    override fun getItemCount() = currentList.size

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Schedule>() {
            override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule) =
                oldItem.id == newItem.id
        }
    }
}
