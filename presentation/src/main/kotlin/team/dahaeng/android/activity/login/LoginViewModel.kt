/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginViewModel.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:26
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import android.content.Context
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.activity.base.ResultEvent
import team.dahaeng.android.domain.aouth.model.User
import team.dahaeng.android.domain.aouth.usecase.KakaoLoginUseCase
import team.dahaeng.android.domain.community.model.Post
import team.dahaeng.android.domain.community.usecase.ImportPostsUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase,
    private val importPostsUseCase: ImportPostsUseCase,
) : BaseViewModel<ResultEvent<User>>() {
    fun login(context: Context) = viewModelScope.launch {
        kakaoLoginUseCase(context)
            .onSuccess { user ->
                event(ResultEvent.Success(user))
            }
            .onFailure { exception ->
                event(ResultEvent.Failure(exception))
            }
    }

    // TODO: 이게 좋은 방법일까
    fun importPostsWithDoneAction(doneAction: (posts: List<Post>) -> Unit) = viewModelScope.launch {
        importPostsUseCase()
            .onSuccess { posts ->
                doneAction(posts)
            }
            .onFailure { exception ->
                event(ResultEvent.Failure(exception))
            }
    }
}
