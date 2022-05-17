package udemy.course.android.studycase.myapplication.presentation.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import udemy.course.android.studycase.myapplication.domain.usecases.movie.GetMovieUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.movie.UpdateMovieUseCase

class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
    ) : ViewModel() {

        fun getMovie() = liveData{
            val movieList = getMovieUseCase.execute()
            emit(movieList)
        }

    fun updateMovie() = liveData{
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}