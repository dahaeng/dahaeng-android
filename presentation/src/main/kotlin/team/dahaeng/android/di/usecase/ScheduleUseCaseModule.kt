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
import team.dahaeng.android.domain.schedule.usecase.schedule.DeleteScheduleUseCase
import team.dahaeng.android.domain.schedule.usecase.schedule.ImportAllSchedulesUseCase
import team.dahaeng.android.domain.schedule.usecase.schedule.ImportSchedulesFromUserUseCase
import team.dahaeng.android.domain.schedule.usecase.schedule.UploadScheduleUseCase

@Module
@InstallIn(ViewModelComponent::class)
object ScheduleUseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideUploadPhotosUseCase(repo: FirebaseRepository): UploadPhotosUseCase =
        UploadPhotosUseCase(repo)

    @Provides
    @ViewModelScoped
    fun provideUploadScheduleUseCase(repo: FirebaseRepository): UploadScheduleUseCase =
        UploadScheduleUseCase(repo)

    @Provides
    @ViewModelScoped
    fun provideImportAllSchedulesUseCase(repo: FirebaseRepository): ImportAllSchedulesUseCase =
        ImportAllSchedulesUseCase(repo)

    @Provides
    @ViewModelScoped
    fun provideImportSchedulesFromUserUseCase(repo: FirebaseRepository): ImportSchedulesFromUserUseCase =
        ImportSchedulesFromUserUseCase(repo)

    @Provides
    @ViewModelScoped
    fun provideDeleteScheduleUseCase(repo: FirebaseRepository): DeleteScheduleUseCase =
        DeleteScheduleUseCase(repo)
}
