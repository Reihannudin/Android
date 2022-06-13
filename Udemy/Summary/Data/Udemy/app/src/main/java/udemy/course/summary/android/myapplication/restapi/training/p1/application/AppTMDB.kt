package udemy.course.summary.android.myapplication.restapi.training.pt1.application

import android.app.Application
import udemy.course.summary.android.myapplication.BuildConfig
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.Injector
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.component.AppComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.component.DaggerAppComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.AppModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.database.RemoteDataModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.network.NetworkModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.movie.MovieOnAirSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.tvshow.TvShowOnAirSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.artist.ArtistPopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.movie.MoviePopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.tvshow.TvShowPopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.trending.TrendingSubComponent

class AppTMDB : Application(), Injector {

    private lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL_API))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMoviePopularSubComponent(): MoviePopularSubComponent {
        return appComponent.moviePopularSubComponent().create()
    }

    override fun createTvShowPopularSubComponent(): TvShowPopularSubComponent {
        return appComponent.tvShowPopularSubComponent().create()
    }

    override fun createArtistPopularSubComponent(): ArtistPopularSubComponent {
        return appComponent.artistPopularSubComponent().create()
    }

    override fun createMovieOnAirSubComponent(): MovieOnAirSubComponent {
        return appComponent.movieOnAirSubComponent().create()
    }

    override fun createTvShowOnAirSubComponent(): TvShowOnAirSubComponent {
        return appComponent.tvShowOnAirSubComponent().create()
    }

    override fun createTrendingSubComponent(): TrendingSubComponent {
        return appComponent.trendingSubComponent().create()
    }


}