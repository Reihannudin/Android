package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.movie.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.movie.MoviePopularViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.movie.GetMoviePopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.movie.UpdateMoviePopularUseCase

class MoviePopularViewModelFactory(
    private val getMoviePopularUseCase: GetMoviePopularUseCase,
    private val updateMoviePopularUseCase: UpdateMoviePopularUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviePopularViewModel(getMoviePopularUseCase, updateMoviePopularUseCase) as T
    }
}