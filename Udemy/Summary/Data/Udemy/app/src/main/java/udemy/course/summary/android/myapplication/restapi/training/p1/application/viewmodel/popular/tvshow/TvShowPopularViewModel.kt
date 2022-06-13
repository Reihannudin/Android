package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.tvshow.GetTvShowPopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.tvshow.UpdateTvShowPopularUseCase

class TvShowPopularViewModel(
    private val getTvShowPopularUseCase: GetTvShowPopularUseCase,
    private val updateTvShowPopularUseCase: UpdateTvShowPopularUseCase
) : ViewModel(){

    fun getTvShowPopular() = liveData{
        val tvShowPopularList = getTvShowPopularUseCase.execute()
        emit(tvShowPopularList)
    }

    fun updateTvShowPopular() = liveData{
        val tvShowPopularList = updateTvShowPopularUseCase.execute()
        emit(tvShowPopularList)
    }
}