package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.movie.GetMoviePopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.movie.UpdateMoviePopularUseCase

class MoviePopularViewModel(
    private val getMoviePopularUseCase: GetMoviePopularUseCase,
    private val updateMoviePopularUseCase: UpdateMoviePopularUseCase
) : ViewModel() {

    fun getMoviePopular() = liveData {
        val moviePopularList = getMoviePopularUseCase.execute()
        emit(moviePopularList)
    }

    fun updateMoviePopular() = liveData {
        val moviePopularList = updateMoviePopularUseCase.execute()
        emit(moviePopularList)
    }
}