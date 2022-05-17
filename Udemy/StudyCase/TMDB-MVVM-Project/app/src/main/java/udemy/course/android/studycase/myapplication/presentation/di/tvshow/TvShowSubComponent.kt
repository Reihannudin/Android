package udemy.course.android.studycase.myapplication.presentation.di.tvshow

import dagger.Subcomponent
import udemy.course.android.studycase.myapplication.presentation.di.movie.MovieSubComponent
import udemy.course.android.studycase.myapplication.presentation.movie.MovieActivity
import udemy.course.android.studycase.myapplication.presentation.tvshow.TvShowActivity

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(TvShowActivity: TvShowActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}