package udemy.course.android.studycase.myapplication.presentation.tvshow.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.studycase.myapplication.domain.usecases.tvshow.GetTvShowUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.tvshow.UpdateTvShowUseCase
import udemy.course.android.studycase.myapplication.presentation.tvshow.viewmodel.TvShowViewModel

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}