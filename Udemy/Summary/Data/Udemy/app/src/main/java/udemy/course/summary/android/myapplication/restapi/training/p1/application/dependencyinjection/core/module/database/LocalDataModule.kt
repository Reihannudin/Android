package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.database

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.onair.MovieOnAirDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.onair.TvShowOnAirDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.ArtistPopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.MoviePopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.TvShowPopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.trending.TrendingDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.impl.MovieOnAirLocalDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.impl.TvShowOnAirLocalDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.impl.ArtistPopularLocalDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.impl.MoviePopularLocalDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.impl.TvShowPopularLocalDataSourceImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.impl.TrendingLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMoviePopularLocalDataSource(moviePopularDao: MoviePopularDao) :MoviePopularLocalDataSource{
        return MoviePopularLocalDataSourceImpl(moviePopularDao)
    }

    @Singleton
    @Provides
    fun provideTvShowPopularLocalDataSource(tvShowPopularDao: TvShowPopularDao) : TvShowPopularLocalDataSource {
        return TvShowPopularLocalDataSourceImpl(tvShowPopularDao)
    }

    @Singleton
    @Provides
    fun provideArtistPopularLocalDataSource(artistPopularDao: ArtistPopularDao) : ArtistPopularLocalDataSource {
        return ArtistPopularLocalDataSourceImpl(artistPopularDao)
    }

    @Singleton
    @Provides
    fun provideMovieOnAirLocalDataSource(movieOnAirDao: MovieOnAirDao) : MovieOnAirLocalDataSource{
        return MovieOnAirLocalDataSourceImpl(movieOnAirDao)
    }

    @Singleton
    @Provides
    fun provideTvShowOnAirLocalDataSource(tvShowOnAirDao: TvShowOnAirDao) : TvShowOnAirLocalDataSource {
        return TvShowOnAirLocalDataSourceImpl(tvShowOnAirDao)
    }

    @Singleton
    @Provides
    fun provideTrendingLocalDataSource(trendingDao: TrendingDao):TrendingLocalDataSource{
        return TrendingLocalDataSourceImpl(trendingDao)
    }

}