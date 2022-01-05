/*
 * Dahaeng © 2021 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [RepositoryModule.kt] created by Ji Sungbin on 22. 1. 6. 오전 3:01
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import team.dahaeng.android.data.aouth.repository.LoginRepositoryImpl
import team.dahaeng.android.domain.aouth.repository.LoginRepository

@Module
@InstallIn(ViewModelScoped::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideLoginRepository(): LoginRepository = LoginRepositoryImpl()
}
