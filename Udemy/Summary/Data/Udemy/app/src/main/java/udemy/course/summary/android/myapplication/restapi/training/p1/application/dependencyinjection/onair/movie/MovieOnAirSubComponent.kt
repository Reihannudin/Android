package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.movie

import dagger.Subcomponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.onair.movie.MovieOnAirTMDBFragment


@MovieOnAirScope
@Subcomponent(modules = [MovieOnAirModule::class])
interface MovieOnAirSubComponent {
    fun inject(movieOnAirTMDBFragment: MovieOnAirTMDBFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieOnAirSubComponent
    }
}