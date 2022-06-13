package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.component

import dagger.Component
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.AppModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.database.CacheDataModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.database.DatabaseModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.database.LocalDataModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.database.RemoteDataModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.network.NetworkModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.repository.RepositoryModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.usecase.UseCaseModule
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.movie.MovieOnAirSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.onair.tvshow.TvShowOnAirSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.artist.ArtistPopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.movie.MoviePopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.tvshow.TvShowPopularSubComponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.trending.TrendingSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class])
interface AppComponent {

    fun moviePopularSubComponent(): MoviePopularSubComponent.Factory
    fun tvShowPopularSubComponent(): TvShowPopularSubComponent.Factory
    fun artistPopularSubComponent(): ArtistPopularSubComponent.Factory
    fun movieOnAirSubComponent(): MovieOnAirSubComponent.Factory
    fun tvShowOnAirSubComponent(): TvShowOnAirSubComponent.Factory
    fun trendingSubComponent(): TrendingSubComponent.Factory
}