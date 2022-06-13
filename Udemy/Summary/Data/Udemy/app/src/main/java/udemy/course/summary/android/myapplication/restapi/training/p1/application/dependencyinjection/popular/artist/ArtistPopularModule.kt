package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.artist

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.artist.factory.ArtistPopularViewModelFactory
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.artist.GetArtistPopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.artist.UpdateArtistPopularUseCase

@Module
class ArtistPopularModule {

    @ArtistPopularScope
    @Provides
    fun provideArtistPopularViewModelFactory(
        getArtistPopularUseCase: GetArtistPopularUseCase,
        updateArtistPopularUseCase: UpdateArtistPopularUseCase
    ):ArtistPopularViewModelFactory{
        return ArtistPopularViewModelFactory(
            getArtistPopularUseCase, updateArtistPopularUseCase
        )
    }
}