package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.tvshow

import dagger.Subcomponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.popular.tvshow.TvShowPopularTMDBFragment

@TvShowPopularScope
@Subcomponent(modules = [TvShowPopularModule::class])
interface TvShowPopularSubComponent {
    fun inject(tvShowPopularTMDBFragment: TvShowPopularTMDBFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowPopularSubComponent
    }
}