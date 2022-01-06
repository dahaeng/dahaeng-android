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