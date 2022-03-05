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
import team.dahaeng.android.domain.user.usecase.KakaoLoginUseCase

@Module
@InstallIn(ViewModelComponent::class)
object AouthUseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideKakaoLoginUseCase(repository: UserRepository): KakaoLoginUseCase =
        KakaoLoginUseCase(repository)
}
