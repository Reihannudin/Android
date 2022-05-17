package udemy.course.android.studycase.myapplication.presentation.di.tvshow

import dagger.Module
import dagger.Provides
import udemy.course.android.studycase.myapplication.domain.usecases.tvshow.GetTvShowUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.tvshow.UpdateTvShowUseCase
import udemy.course.android.studycase.myapplication.presentation.tvshow.viewmodel.factory.TvShowViewModelFactory

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase, updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }
}
