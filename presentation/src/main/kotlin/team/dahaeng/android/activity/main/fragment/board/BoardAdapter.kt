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
import team.dahaeng.android.databinding.LayoutPostBinding
import team.dahaeng.android.domain.schedule.model.post.Post

class BoardAdapter(
    private val onPostClick: (Post) -> Unit,
) : ListAdapter<Post, BoardAdapter.BoardViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val binding = LayoutPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(binding, onPostClick)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BoardViewHolder(
        private val binding: LayoutPostBinding,
        private val onPostClick: (Post) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.run {
                this.post = post
                root.setOnClickListener {
                    onPostClick(post)
                }
            }
        }
    }

    override fun getItemId(position: Int) = getItem(position).id

    override fun getItemCount() = currentList.size

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Post>() {
            override fun areContentsTheSame(oldItem: Post, newItem: Post) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Post, newItem: Post) =
                oldItem.id == newItem.id
        }
    }
}
