/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [WriteViewModel.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.wirte

import android.net.Uri
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseEvent
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.domain.community.usecase.UploadFirebaseStorageUseCase
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(
    private val uploadFirebaseStorageUseCase: UploadFirebaseStorageUseCase
) : BaseViewModel<BaseEvent>() {

    fun uploadImage(uri: Uri) = viewModelScope.launch {
        uploadFirebaseStorageUseCase(uri)
    }

}