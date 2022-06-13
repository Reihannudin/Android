package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.movie

import dagger.Subcomponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.popular.movie.MoviePopularTMDBFragment

@MoviePopularScope
@Subcomponent(modules = [MoviePopularModule::class])
interface MoviePopularSubComponent {
    fun inject(moviePopularTMDBFragment: MoviePopularTMDBFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MoviePopularSubComponent
    }
}