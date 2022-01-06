package team.dahaeng.android.activity.community.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import team.dahaeng.android.data.aouth.repository.FirebaseRepositoryImpl
import team.dahaeng.android.domain.aouth.repository.FirebaseRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideFirebaseRepository(): FirebaseRepository = FirebaseRepositoryImpl()
}