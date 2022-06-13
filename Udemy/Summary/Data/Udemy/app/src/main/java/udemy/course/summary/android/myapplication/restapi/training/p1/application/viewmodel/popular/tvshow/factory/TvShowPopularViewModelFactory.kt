package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.tvshow.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.tvshow.TvShowPopularViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.movie.GetMoviePopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.tvshow.GetTvShowPopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.tvshow.UpdateTvShowPopularUseCase

class TvShowPopularViewModelFactory(
    private val getTvShowPopularUseCase: GetTvShowPopularUseCase,
    private val updateTvShowPopularUseCase: UpdateTvShowPopularUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowPopularViewModel(getTvShowPopularUseCase, updateTvShowPopularUseCase) as T
    }
}