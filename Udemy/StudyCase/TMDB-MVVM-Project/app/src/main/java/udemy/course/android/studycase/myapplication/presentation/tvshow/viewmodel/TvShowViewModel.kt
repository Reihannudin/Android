package udemy.course.android.studycase.myapplication.presentation.tvshow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import udemy.course.android.studycase.myapplication.domain.usecases.tvshow.GetTvShowUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.tvshow.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {

    fun getTvShow() = liveData {
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList = updateTvShowUseCase.execute()
        emit(tvShowList)
    }
}