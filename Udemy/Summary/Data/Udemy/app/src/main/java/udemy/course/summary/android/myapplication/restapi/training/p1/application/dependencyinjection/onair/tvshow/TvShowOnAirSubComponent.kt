package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.tvshow

import dagger.Subcomponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.onair.tvshow.TvShowOnAirTMDBFragment

@TvShowOnAirScope
@Subcomponent(modules = [TvShowOnAirModule::class])
interface TvShowOnAirSubComponent {
    fun inject(tvShowOnAirTMDBFragment: TvShowOnAirTMDBFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowOnAirSubComponent
    }
}