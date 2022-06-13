package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.tvshow

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.tvshow.factory.TvShowPopularViewModelFactory
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.tvshow.GetTvShowPopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.tvshow.UpdateTvShowPopularUseCase

@Module
class TvShowPopularModule {

    @TvShowPopularScope
    @Provides
    fun provideTvShowPopularViewModelFactory(
        getTvShowPopularUseCase: GetTvShowPopularUseCase,
        updateTvShowPopularUseCase: UpdateTvShowPopularUseCase
    ) : TvShowPopularViewModelFactory {
        return TvShowPopularViewModelFactory(
            getTvShowPopularUseCase,
            updateTvShowPopularUseCase
        )
    }
}