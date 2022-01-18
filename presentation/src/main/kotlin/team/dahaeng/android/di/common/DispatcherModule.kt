/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [DispatcherModule.kt] created by Ji Sungbin on 22. 1. 13. 오후 7:19
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.di.common

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import team.dahaeng.android.di.qualifier.IoDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object DispatcherModule {
    @Provides
    @IoDispatcher
    @ViewModelScoped
    fun provideIoCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
}