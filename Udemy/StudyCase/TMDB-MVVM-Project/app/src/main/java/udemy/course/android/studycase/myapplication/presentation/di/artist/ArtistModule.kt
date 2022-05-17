package udemy.course.android.studycase.myapplication.presentation.di.artist

import dagger.Module
import dagger.Provides
import udemy.course.android.studycase.myapplication.domain.usecases.artist.GetArtistUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.artist.UpdateArtistUseCase
import udemy.course.android.studycase.myapplication.presentation.artist.viewmodel.factory.ArtistViewModelFactory

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideMovietViewModelFactory(
        getArtistUseCase: GetArtistUseCase, updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}