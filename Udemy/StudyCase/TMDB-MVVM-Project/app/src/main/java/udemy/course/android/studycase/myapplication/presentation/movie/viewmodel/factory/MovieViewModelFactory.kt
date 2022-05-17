package udemy.course.android.studycase.myapplication.presentation.movie.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.studycase.myapplication.domain.usecases.movie.GetMovieUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.movie.UpdateMovieUseCase
import udemy.course.android.studycase.myapplication.presentation.movie.viewmodel.MovieViewModel

class MovieViewModelFactory(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase, updateMovieUseCase) as T
    }
}