/*
 * Dahaeng © 2022 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [CommunityViewModel.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:12
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.community

import android.net.Uri
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseEvent
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.domain.aouth.usecase.UploadFirebaseStorageUseCase
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(private val uploadFirebaseStorageUseCase: UploadFirebaseStorageUseCase) :
    BaseViewModel<BaseEvent>() {

    fun uploadImage(uri: Uri) = viewModelScope.launch {
        val result = uploadFirebaseStorageUseCase(uri)
    }

}
