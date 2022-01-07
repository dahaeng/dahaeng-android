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
import team.dahaeng.android.domain.aouth.repository.FirebaseRepository
import team.dahaeng.android.domain.aouth.usecase.UploadFirebaseStorageUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideUploadFirebaseStorageUseCase(repository: FirebaseRepository) =
        UploadFirebaseStorageUseCase(repository)
}