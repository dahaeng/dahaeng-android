/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [CommunityActiivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.community

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.activity.community.wirte.WriteActivity
import team.dahaeng.android.databinding.ActivityCommunityBinding
import team.dahaeng.android.util.extensions.collectWithLifecycle

@AndroidEntryPoint
class CommunityActivity : BaseActivity<ActivityCommunityBinding, CommunityViewModel>(
    R.layout.activity_community
) {

    override val vm: CommunityViewModel by viewModels()
    private val adapter by lazy {
        CommunityAdapter().apply {
            setHasStableIds(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.rvCommunity.setHasFixedSize(true)
        binding.rvCommunity.adapter = adapter
        vm.reimportPosts()

        binding.btnWritepost.setOnClickListener {
            val intent = Intent(applicationContext, WriteActivity::class.java)
            startActivity(intent)
        }

        vm.posts.collectWithLifecycle(this) { posts ->
            if (posts.isNotEmpty()) {
                adapter.submitList(posts)
            }
        }
    }
}
