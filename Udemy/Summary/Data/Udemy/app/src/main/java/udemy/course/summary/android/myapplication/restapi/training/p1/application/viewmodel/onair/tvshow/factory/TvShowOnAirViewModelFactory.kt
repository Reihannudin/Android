package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.onair.tvshow.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.onair.tvshow.TvShowOnAirViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.tvshow.GetTVShowOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.tvshow.UpdateTvShowOnAirUseCase

class TvShowOnAirViewModelFactory(
    private val getTVShowOnAirUseCase: GetTVShowOnAirUseCase,
    private val updateTvShowOnAirUseCase: UpdateTvShowOnAirUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowOnAirViewModel(getTVShowOnAirUseCase, updateTvShowOnAirUseCase) as T
    }
}