package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.repository

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.MovieOnAirRepositoryImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.TvShowOnAirRepositoryImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.ArtistPopularRepositoryImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularCahceDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.MoviePopularRepositoryImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.TvShowPopularRepositoryImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.TrendingRepositoryImpl
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.onair.MovieOnAirRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.onair.TvShowOnAirRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.ArtistPopularRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.MoviePopularRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.TvShowPopularRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.trending.TrendingRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMoviePopularRepository(
        moviePopularRemoteDataSource: MoviePopularRemoteDataSource,
        moviePopularLocalDataSource: MoviePopularLocalDataSource,
        moviePopularCacheDataSource: MoviePopularCacheDataSource
    ): MoviePopularRepository {

        return MoviePopularRepositoryImpl(
            moviePopularRemoteDataSource,
            moviePopularLocalDataSource,
            moviePopularCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowPopularRepository(
        tvShowPopularRemoteDataSource: TvShowPopularRemoteDataSource,
        tvShowPopularLocalDataSource: TvShowPopularLocalDataSource,
        tvShowPopularCacheDataSource: TvShowPopularCacheDataSource
    ): TvShowPopularRepository {

        return TvShowPopularRepositoryImpl(
            tvShowPopularRemoteDataSource,
            tvShowPopularLocalDataSource,
            tvShowPopularCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistPopularRepository(
        artistPopularRemoteDataSource: ArtistPopularRemoteDataSource,
        artistPopularLocalDataSource: ArtistPopularLocalDataSource,
        artistPopularCacheDataSource: ArtistPopularCahceDataSource
    ): ArtistPopularRepository {

        return ArtistPopularRepositoryImpl(
            artistPopularRemoteDataSource,
            artistPopularLocalDataSource,
            artistPopularCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideMovieOnAirRepository(
        movieOnAirRemoteDataSource: MovieOnAirRemoteDataSource,
        movieOnAirLocalDataSource: MovieOnAirLocalDataSource,
        movieOnAirCacheDataSource: MovieOnAirCacheDataSource
    ): MovieOnAirRepository {

        return MovieOnAirRepositoryImpl(
            movieOnAirRemoteDataSource,
            movieOnAirLocalDataSource,
            movieOnAirCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowOnAirRepository(
        tvShowOnAirRemoteDataSource: TvShowOnAirRemoteDataSource,
        tvShowOnAirLocalDataSource: TvShowOnAirLocalDataSource,
        tvShowOnAirCacheDataSource: TvShowOnAirCacheDataSource
    ): TvShowOnAirRepository {

        return TvShowOnAirRepositoryImpl(
            tvShowOnAirRemoteDataSource,
            tvShowOnAirLocalDataSource,
            tvShowOnAirCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTrendingRepository(
        trendingRemoteDataSource: TrendingRemoteDataSource,
        trendingLocalDataSource: TrendingLocalDataSource,
        trendingCacheDataSource: TrendingCacheDataSource
    ):TrendingRepository{

        return TrendingRepositoryImpl(
            trendingRemoteDataSource,
            trendingLocalDataSource,
            trendingCacheDataSource
        )
    }
}