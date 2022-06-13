package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module

import android.content.Context
import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.movie.MovieOnAirSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.artist.ArtistPopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.movie.MoviePopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.tvshow.TvShowPopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.trending.TrendingSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular
import javax.inject.Singleton

@Module(subcomponents = [MoviePopularSubComponent::class, TvShowPopularSubComponent::class,
    ArtistPopularSubComponent::class, MovieOnAirSubComponent::class,
    TvShowPopularSubComponent::class, TrendingSubComponent::class])
class AppModule(private val context : Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}