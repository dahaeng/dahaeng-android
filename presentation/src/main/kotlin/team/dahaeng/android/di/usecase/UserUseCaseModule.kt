/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [AouthUseCaseModule.kt] created by Ji Sungbin on 22. 1. 6. 오전 4:21
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import team.dahaeng.android.domain.user.repository.UserRepository
import team.dahaeng.android.domain.user.usecase.GetUserUseCase
import team.dahaeng.android.domain.user.usecase.KakaoLoginUseCase
import team.dahaeng.android.domain.user.usecase.RemoveUserUseCase
import team.dahaeng.android.domain.user.usecase.UpdateUserUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UserUseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideKakaoLoginUseCase(repo: UserRepository): KakaoLoginUseCase =
        KakaoLoginUseCase(repo)

    @Provides
    @ViewModelScoped
    fun provideUpdateUserUseCase(repo: UserRepository): UpdateUserUseCase =
        UpdateUserUseCase(repo)

    @Provides
    @ViewModelScoped
    fun provideRemoveUserUseCase(repo: UserRepository): RemoveUserUseCase =
        RemoveUserUseCase(repo)

    @Provides
    @ViewModelScoped
    fun provideGetUserUseCase(repo: UserRepository): GetUserUseCase =
        GetUserUseCase(repo)
}
