package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.onair.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.tvshow.GetTVShowOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.tvshow.UpdateTvShowOnAirUseCase

class TvShowOnAirViewModel(
    private val getTvShowOnAirUseCase: GetTVShowOnAirUseCase,
    private val updateTvShowOnAirUseCase: UpdateTvShowOnAirUseCase
) : ViewModel() {

    fun getTvShowOnAir() = liveData {
        val tvShowOnAirList = getTvShowOnAirUseCase.execute()
        emit(tvShowOnAirList)
    }

    fun updateTvShowOnAir() = liveData {
        val tvShowOnAirList = updateTvShowOnAirUseCase.execute()
        emit(tvShowOnAirList)
    }
}