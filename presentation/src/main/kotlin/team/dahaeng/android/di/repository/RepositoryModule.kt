/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [RepositoryModule.kt] created by Ji Sungbin on 22. 1. 6. 오전 3:01
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.di.repository

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import team.dahaeng.android.data.schedule.repository.FirebaseRepositoryImpl
import team.dahaeng.android.data.user.repository.UserRepositoryImpl
import team.dahaeng.android.domain.schedule.repository.FirebaseRepository
import team.dahaeng.android.domain.user.repository.UserRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideUserRepository(@ApplicationContext context: Context): UserRepository =
        UserRepositoryImpl(context)

    @Provides
    @ViewModelScoped
    fun provideFirebaseRepository(): FirebaseRepository = FirebaseRepositoryImpl()
}
