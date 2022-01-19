/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [PostAdapter.kt] created by Ji Sungbin on 22. 1. 19. 오후 4:28
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.main.fragment.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import team.dahaeng.android.databinding.LayoutPostBinding
import team.dahaeng.android.domain.community.model.Post

class PostAdapter(private val onPostClick: (Post) -> Unit) :
    ListAdapter<Post, PostAdapter.ViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onPostClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    /* TODO: 메모리 할당 해제
    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        GlideApp.with(holder.itemView).clear(holder.)
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        Glide.with(context)
            .clear(holder.imageView)
    }*/

    class ViewHolder(
        private val binding: LayoutPostBinding,
        private val onPostClick: (Post) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.run {
                this.post = post
                root.setOnClickListener {
                    onPostClick(post)
                }
                executePendingBindings()
            }
        }
    }

    override fun getItemId(position: Int) = getItem(position).id

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Post>() {
            override fun areContentsTheSame(oldItem: Post, newItem: Post) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Post, newItem: Post) =
                oldItem.id == newItem.id
        }
    }
}
