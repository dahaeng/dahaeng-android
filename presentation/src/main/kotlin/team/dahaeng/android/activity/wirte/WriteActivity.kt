/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [WriteActivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.wirte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
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

        val result =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.data?.data != null) {
                    vm.uploadImage(result.data?.data!!) // registerForActivityResult는 미리 생성하고 실행해야함
                }
            }

        binding.butnUpload.setOnClickListener {
            // TODO: 이미지 로드 -> TedImagePicker 등등 이미지 피커 라이브러리 사용
            val imagePickIntent = Intent(Intent.ACTION_PICK)
            imagePickIntent.type = "image/*"
            result.launch(imagePickIntent)
        }

    }
}