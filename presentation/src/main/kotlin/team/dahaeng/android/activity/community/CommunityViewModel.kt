/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [CommunityViewModel.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:12
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.community

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.activity.base.ResultEvent
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.domain.community.usecase.ImportPostsUseCase
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val importPostsUseCase: ImportPostsUseCase
) : BaseViewModel<ResultEvent<Nothing>>() {

    private val _posts = MutableStateFlow(DataStore.posts)
    val posts = _posts.asStateFlow()

    fun reimportPosts() = viewModelScope.launch {
        importPostsUseCase()
            .onSuccess { posts ->
                DataStore.updatePosts(posts)
                _posts.emit(posts)
            }
            .onFailure { exception ->
                event(ResultEvent.Failure(exception))
            }
    }
}
