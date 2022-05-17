package udemy.course.android.studycase.myapplication.presentation.di.movie

import dagger.Module
import dagger.Provides
import udemy.course.android.studycase.myapplication.domain.usecases.movie.GetMovieUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.movie.UpdateMovieUseCase
import udemy.course.android.studycase.myapplication.presentation.movie.viewmodel.factory.MovieViewModelFactory

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase, updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase, updateMovieUseCase)
    }
}