package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.database

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.impl.MovieOnAirCacheDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.impl.TvShowOnAirCacheDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularCahceDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.impl.ArtistPopularCacheDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.impl.MoviePopularCacheDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.impl.TvShowPopularCacheDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.impl.TrendingCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMoviePopularCacheDataSource(): MoviePopularCacheDataSource {
        return MoviePopularCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowPopularCacheDataSource(): TvShowPopularCacheDataSource {
        return TvShowPopularCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistPopularCacheDataSource(): ArtistPopularCahceDataSource {
        return ArtistPopularCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideMovieOnAirCacheDataSource(): MovieOnAirCacheDataSource {
        return MovieOnAirCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowOnAirCacheDataSource(): TvShowOnAirCacheDataSource {
        return TvShowOnAirCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTrendingCacheDataSource(): TrendingCacheDataSource {
        return TrendingCacheDataSourceImpl()
    }
}