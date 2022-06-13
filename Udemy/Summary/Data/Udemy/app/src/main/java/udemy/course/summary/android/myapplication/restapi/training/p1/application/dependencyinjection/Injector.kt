package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection

import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.movie.MovieOnAirSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.tvshow.TvShowOnAirSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.artist.ArtistPopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.movie.MoviePopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.tvshow.TvShowPopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.trending.TrendingSubComponent

interface Injector {
    fun createMoviePopularSubComponent(): MoviePopularSubComponent
    fun createTvShowPopularSubComponent(): TvShowPopularSubComponent
    fun createArtistPopularSubComponent(): ArtistPopularSubComponent
    fun createMovieOnAirSubComponent(): MovieOnAirSubComponent
    fun createTvShowOnAirSubComponent(): TvShowOnAirSubComponent
    fun createTrendingSubComponent(): TrendingSubComponent
}