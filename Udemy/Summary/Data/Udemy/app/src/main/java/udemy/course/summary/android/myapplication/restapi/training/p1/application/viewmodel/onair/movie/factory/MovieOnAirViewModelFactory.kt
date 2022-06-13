package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.onair.movie.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.onair.movie.MovieOnAirViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.movie.GetMovieOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.movie.UpdateMovieOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.tvshow.UpdateTvShowOnAirUseCase

class MovieOnAirViewModelFactory(
    private val getMovieOnAirUseCase: GetMovieOnAirUseCase,
    private val updateMovieOnAirUseCase: UpdateMovieOnAirUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieOnAirViewModel(getMovieOnAirUseCase, updateMovieOnAirUseCase) as T
    }
}