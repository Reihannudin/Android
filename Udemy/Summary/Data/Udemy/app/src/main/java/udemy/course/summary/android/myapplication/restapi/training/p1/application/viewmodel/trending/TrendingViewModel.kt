package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.trending

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.movie.GetMovieOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.trending.GetTrendingUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.trending.UpdateTrendingUseCase

class TrendingViewModel(
    private val getTrendingUseCase: GetTrendingUseCase,
    private val updateTrendingUseCase: UpdateTrendingUseCase
) : ViewModel() {

    fun getTrending() = liveData {
        val trendingList = getTrendingUseCase.execute()
        emit(trendingList)
    }

    fun updateTrending() = liveData {
        val trendingList = updateTrendingUseCase.execute()
        emit(trendingList)
    }
}