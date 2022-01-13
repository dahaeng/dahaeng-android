/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [WriteActivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.community.wirte

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityWriteBinding

@AndroidEntryPoint
class WriteActivity : BaseActivity<ActivityWriteBinding, WriteViewModel>(
    R.layout.activity_write
) {

    override val vm: WriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
        val result =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                val uri = result.data?.data
                if (uri != null) {
                    vm.setPostImage(uri)
                    Glide.with(this).load(uri).fitCenter().into(binding.ivTravelphoto)
                }
            }

        binding.ivTravelphoto.setOnClickListener {
            // TODO: 이미지 로드 -> TedImagePicker 등등 이미지 피커 라이브러리 사용
            val imagePickIntent = Intent(Intent.ACTION_PICK)
            imagePickIntent.type = "image/*"
            result.launch(imagePickIntent)
        }
        binding.btnUpload.setOnClickListener {
            vm.uploadImage(vm.getPostImage()!!)
            vm.setPost(
                binding.textinputedittextTitle.text.toString(),
                binding.textinputedittextContent.text.toString(),
                binding.autocompletetvExpense.text.toString(),
                binding.autocompletetvPeriod.text.toString(),
                binding.autocompletetvTheme.text.toString()
            )
            vm.uploadPost()
            finish()
        }

    }

    private fun setAdapter() {
        val themes = resources.getStringArray(R.array.themes)
        val expenses = resources.getStringArray(R.array.expenses)
        val periods = resources.getStringArray(R.array.periods)
        val arrayThemeAdapter = ArrayAdapter(this, R.layout.dropdown_item, themes)
        val arrayExpenseAdapter = ArrayAdapter(this, R.layout.dropdown_item, expenses)
        val arrayPeriodAdapter = ArrayAdapter(this, R.layout.dropdown_item, periods)
        binding.autocompletetvTheme.setAdapter(arrayThemeAdapter)
        binding.autocompletetvExpense.setAdapter(arrayExpenseAdapter)
        binding.autocompletetvPeriod.setAdapter(arrayPeriodAdapter)
    }
}