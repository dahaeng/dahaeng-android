/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [CommunityUseCaseModule.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import team.dahaeng.android.domain.community.usecase.ImportPostsUseCase
import team.dahaeng.android.domain.community.usecase.UploadImageUseCase
import team.dahaeng.android.domain.community.usecase.UploadPostUseCase

@Module
@InstallIn(ViewModelComponent::class)
object CommunityUseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideUploadImageUseCase(repository: FirebaseRepository): UploadImageUseCase =
        UploadImageUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideUploadPostUseCase(repository: FirebaseRepository): UploadPostUseCase =
        UploadPostUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideImportPostsUseCaseToViewModel(repository: FirebaseRepository): ImportPostsUseCase =
        ImportPostsUseCase(repository)
}
