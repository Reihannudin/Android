package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.movie

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.movie.factory.MoviePopularViewModelFactory
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.movie.GetMoviePopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.movie.UpdateMoviePopularUseCase

@Module
class MoviePopularModule {

    @MoviePopularScope
    @Provides
    fun provideMoviePopularViewModelFactory(
        getMoviePopularUseCase: GetMoviePopularUseCase,
        updateMoviePopularUseCase: UpdateMoviePopularUseCase
    ) : MoviePopularViewModelFactory {
        return MoviePopularViewModelFactory(
            getMoviePopularUseCase, updateMoviePopularUseCase)
    }
}