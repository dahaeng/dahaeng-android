/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [CommunityAdapter.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.community

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import team.dahaeng.android.databinding.PostItemBinding
import team.dahaeng.android.domain.community.model.Post

class CommunityAdapter : ListAdapter<Post, CommunityAdapter.PostViewHolder>(PostDiffCallback()) {

    private val storageRef by lazy { Firebase.storage.reference }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommunityAdapter.PostViewHolder {
        return PostViewHolder(
            PostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CommunityAdapter.PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PostViewHolder(
        private val binding: PostItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.executePendingBindings()
            storageRef.child("image").child(post.imageUrl).downloadUrl.addOnSuccessListener { uri ->
                Glide.with(binding.root).load(uri).fitCenter().into(binding.ivTravelphoto)
            }.addOnFailureListener { exception ->
                Log.e("GLIDE EXCEPTION", exception.message.toString())
            }
        }
    }

    private class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

        @SuppressLint
        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.content == newItem.content
        }
    }

    override fun getItemId(position: Int) = getItem(position).id
}
