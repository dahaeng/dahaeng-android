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
    fun provideUploadPhotosUseCase(repository: FirebaseRepository): UploadPhotosUseCase =
        UploadPhotosUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideUploadScheduleUseCase(repository: FirebaseRepository): UploadScheduleUseCase =
        UploadScheduleUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideImportAllSchedulesUseCase(repository: FirebaseRepository): ImportAllSchedulesUseCase =
        ImportAllSchedulesUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideImportSchedulesFromUserUseCase(repository: FirebaseRepository): ImportSchedulesFromUserUseCase =
        ImportSchedulesFromUserUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideDeleteScheduleUseCase(reposiotry: FirebaseRepository): DeleteScheduleUseCase =
        DeleteScheduleUseCase(reposiotry)
}
