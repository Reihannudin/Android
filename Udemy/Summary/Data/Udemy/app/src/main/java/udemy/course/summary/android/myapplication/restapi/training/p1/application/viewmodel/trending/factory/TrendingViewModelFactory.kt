package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.trending.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.trending.TrendingViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.trending.GetTrendingUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.trending.UpdateTrendingUseCase

class TrendingViewModelFactory(
    private val getTrendingUseCase: GetTrendingUseCase,
    private val updateTrendingUseCase: UpdateTrendingUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TrendingViewModel(getTrendingUseCase, updateTrendingUseCase) as T
    }
}