package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.trending

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.trending.factory.TrendingViewModelFactory
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.trending.GetTrendingUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.trending.UpdateTrendingUseCase

@Module
class TrendingModule {

    @TrendingScope
    @Provides
    fun provideTrendingViewModelFactory(
        getTrendingUseCase: GetTrendingUseCase,
        updateTrendingUseCase: UpdateTrendingUseCase
    ) : TrendingViewModelFactory {
        return TrendingViewModelFactory(
            getTrendingUseCase, updateTrendingUseCase
        )
    }
}