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
import team.dahaeng.android.domain.community.repository.TMapRepository
import team.dahaeng.android.domain.community.repository.TourRepository
import team.dahaeng.android.domain.community.usecase.post.ImportPostsUseCase
import team.dahaeng.android.domain.community.usecase.post.UploadImageUseCase
import team.dahaeng.android.domain.community.usecase.post.UploadPostUseCase
import team.dahaeng.android.domain.community.usecase.schedule.*

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

    @Provides
    @ViewModelScoped
    fun provideChangeScheduleUseCase(repository: FirebaseRepository): ChangeScheduleUseCase =
        ChangeScheduleUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideImportSearchKeywordUseCase(repository: TourRepository): ImportSearchKeywordUseCase =
        ImportSearchKeywordUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideTMapFullTextGeocodingUseCase(repository: TMapRepository): TMapFullTextGeocodingUseCase =
        TMapFullTextGeocodingUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideTMapReverseGeocodingUseCase(repository: TMapRepository): TMapReverseGeocodingUseCase =
        TMapReverseGeocodingUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideImportAreaCodeUseCase(repository: TourRepository): ImportAreaCodeUseCase =
        ImportAreaCodeUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideImportCategoryCodeUseCase(repository: TourRepository): ImportCategoryCodeUseCase =
        ImportCategoryCodeUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideImportAreaBasedListUseCase(repository: TourRepository): ImportAreaBasedListUseCase =
        ImportAreaBasedListUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideImportLocationBasedListUseCase(repository: TourRepository): ImportLocationBasedListUseCase =
        ImportLocationBasedListUseCase(repository)
}
