package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.onair.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.movie.GetMovieOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.movie.UpdateMovieOnAirUseCase

class MovieOnAirViewModel(
    private val getMovieOnAirUseCase: GetMovieOnAirUseCase,
    private val updateMovieOnAirUseCase: UpdateMovieOnAirUseCase
) : ViewModel() {

    fun getMovieOnAir() = liveData {
        val movieOnAirList = getMovieOnAirUseCase.execute()
        emit(movieOnAirList)
    }

    fun updateMovieOnAir() = liveData {
        val movieOnAirList = updateMovieOnAirUseCase.execute()
        emit(movieOnAirList)
    }
}