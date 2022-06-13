package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.trending

import dagger.Subcomponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.trending.TrendingTMDBFragment

@TrendingScope
@Subcomponent(modules = [TrendingModule::class])
interface TrendingSubComponent {
    fun inject(trendingTMDBFragment: TrendingTMDBFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TrendingSubComponent
    }
}