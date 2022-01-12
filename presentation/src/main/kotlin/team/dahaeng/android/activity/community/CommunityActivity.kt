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
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.activity.wirte.WriteActivity
import team.dahaeng.android.databinding.ActivityCommunityBinding

@AndroidEntryPoint
class CommunityActivity : BaseActivity<ActivityCommunityBinding, CommunityViewModel>(
    R.layout.activity_community
) {

    override val vm: CommunityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.rvCommunity.adapter = CommunityAdapter()
        vm.importPostList()

        binding.btnWritepost.setOnClickListener {
            val intent = Intent(applicationContext, WriteActivity::class.java)
            startActivity(intent)
        }

        vm.postList.observe(this, { postList ->
            if (postList.isNotEmpty()) {
                (binding.rvCommunity.adapter as CommunityAdapter).submitList(postList)
            }
        })

    }

}
