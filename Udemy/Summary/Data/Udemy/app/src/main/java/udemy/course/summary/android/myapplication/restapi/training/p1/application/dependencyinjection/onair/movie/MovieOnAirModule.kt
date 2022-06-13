package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.movie

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.onair.movie.factory.MovieOnAirViewModelFactory
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.movie.GetMovieOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.movie.UpdateMovieOnAirUseCase

@Module
class MovieOnAirModule {

    @MovieOnAirScope
    @Provides
    fun provideMovieOnAirViewModelFactory(
        getMovieOnAirUseCase: GetMovieOnAirUseCase,
        updateMovieOnAirUseCase: UpdateMovieOnAirUseCase
    ): MovieOnAirViewModelFactory {
        return MovieOnAirViewModelFactory(
            getMovieOnAirUseCase,
            updateMovieOnAirUseCase
        )
    }
}