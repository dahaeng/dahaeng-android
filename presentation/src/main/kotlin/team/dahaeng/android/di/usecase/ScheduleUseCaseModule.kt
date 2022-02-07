package team.dahaeng.android.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import team.dahaeng.android.domain.community.repository.FirebaseRepository
import team.dahaeng.android.domain.schedule.usecase.ImportScheduleUseCase
import team.dahaeng.android.domain.schedule.usecase.UploadScheduleUseCase

@Module
@InstallIn(ViewModelComponent::class)
object ScheduleUseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideUploadScheduleUseCase(reposiotry: FirebaseRepository): UploadScheduleUseCase =
        UploadScheduleUseCase(reposiotry)

    @Provides
    @ViewModelScoped
    fun provideImportScheduleUseCase(repository: FirebaseRepository): ImportScheduleUseCase =
        ImportScheduleUseCase(repository)
}
