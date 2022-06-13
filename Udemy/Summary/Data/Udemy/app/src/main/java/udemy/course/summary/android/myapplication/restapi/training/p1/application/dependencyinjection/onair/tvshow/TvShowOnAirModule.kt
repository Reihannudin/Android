package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.tvshow

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.onair.tvshow.factory.TvShowOnAirViewModelFactory
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.tvshow.GetTVShowOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.tvshow.UpdateTvShowOnAirUseCase

@Module
class TvShowOnAirModule {

    @TvShowOnAirScope
    @Provides
    fun provideTvShowOnAirViewModelFactory(
        getTVShowOnAirUseCase: GetTVShowOnAirUseCase,
        updateTvShowOnAirUseCase: UpdateTvShowOnAirUseCase
    ): TvShowOnAirViewModelFactory {
        return TvShowOnAirViewModelFactory(
            getTVShowOnAirUseCase,
            updateTvShowOnAirUseCase
        )
    }
}