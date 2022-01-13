/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [UseCaseModule.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.community.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import team.dahaeng.android.domain.community.usecase.ImportFirebaseStorageUseCase
import team.dahaeng.android.domain.community.usecase.UploadImageToStorageUseCase
import team.dahaeng.android.domain.community.usecase.UploadPostToStorageUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideUploadImageToStorageUseCase(repository: FirebaseRepository) =
        UploadImageToStorageUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideUploadPostToStorageUseCase(repository: FirebaseRepository) =
        UploadPostToStorageUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideImportFirebaseStorageUseCase(repository: FirebaseRepository) =
        ImportFirebaseStorageUseCase(repository)

}