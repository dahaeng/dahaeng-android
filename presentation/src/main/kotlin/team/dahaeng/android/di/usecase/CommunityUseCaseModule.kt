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
import team.dahaeng.android.domain.schedule.repository.FirebaseRepository
import team.dahaeng.android.domain.schedule.usecase.UploadPhotosUseCase
import team.dahaeng.android.domain.schedule.usecase.post.ImportAllPostsUseCase
import team.dahaeng.android.domain.schedule.usecase.post.UploadPostUseCase
import team.dahaeng.android.domain.schedule.usecase.schedule.DeleteScheduleUseCase
import team.dahaeng.android.domain.schedule.usecase.schedule.ImportScheduleUseCase
import team.dahaeng.android.domain.schedule.usecase.schedule.UploadScheduleUseCase

@Module
@InstallIn(ViewModelComponent::class)
object CommunityUseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideUploadImageUseCase(repository: FirebaseRepository): UploadPhotosUseCase =
        UploadPhotosUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideUploadPostUseCase(repository: FirebaseRepository): UploadPostUseCase =
        UploadPostUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideImportPostsUseCaseToViewModel(repository: FirebaseRepository): ImportAllPostsUseCase =
        ImportAllPostsUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideUploadScheduleUseCase(reposiotry: FirebaseRepository): UploadScheduleUseCase =
        UploadScheduleUseCase(reposiotry)

    @Provides
    @ViewModelScoped
    fun provideImportScheduleUseCase(repository: FirebaseRepository): ImportScheduleUseCase =
        ImportScheduleUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideDeleteScheduleUseCase(reposiotry: FirebaseRepository): DeleteScheduleUseCase =
        DeleteScheduleUseCase(reposiotry)
}
