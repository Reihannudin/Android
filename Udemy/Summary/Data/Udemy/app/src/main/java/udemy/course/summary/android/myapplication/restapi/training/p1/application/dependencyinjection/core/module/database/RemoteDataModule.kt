package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.database

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.api.service.TMDBService
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.impl.MovieOnAirRemoteDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.impl.TvShowOnAirRemoteDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.impl.ArtistPopularRemoteDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.impl.MoviePopularRemoteDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.impl.TvShowPopularRemoteDataSOurceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.impl.TrendingRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {

    @Singleton
    @Provides
    fun provideMoviePopularRemoteDataSource(tmdbService: TMDBService): MoviePopularRemoteDataSource{
        return MoviePopularRemoteDataSourceImpl(
            tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowPopularRemoteDataSource(tmdbServie : TMDBService) : TvShowPopularRemoteDataSource{
        return TvShowPopularRemoteDataSOurceImpl(
            tmdbServie, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistPopularRemoteDataSource(tmdbService : TMDBService) : ArtistPopularRemoteDataSource {
        return ArtistPopularRemoteDataSourceImpl(
            tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideMovieOnAirRemoteDataSource(tmdbService : TMDBService) : MovieOnAirRemoteDataSource {
        return MovieOnAirRemoteDataSourceImpl(
            tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowOnAirRemoteDataSource(tmdbService : TMDBService) : TvShowOnAirRemoteDataSource {
        return TvShowOnAirRemoteDataSourceImpl(
            tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTrendingRemoteDataSource(tmdbService : TMDBService) : TrendingRemoteDataSource {
        return TrendingRemoteDataSourceImpl(
            tmdbService, apiKey)
    }
}