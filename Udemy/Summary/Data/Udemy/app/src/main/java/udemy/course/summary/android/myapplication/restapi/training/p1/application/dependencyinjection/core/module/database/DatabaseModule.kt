package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.onair.MovieOnAirDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.onair.TvShowOnAirDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.ArtistPopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.MoviePopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.TvShowPopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.trending.TrendingDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.room.TMDBDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context :Context) : TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbClient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMoviePopularDao(tmdbDatabase: TMDBDatabase) :MoviePopularDao{
        return tmdbDatabase.moviePopularDao()
    }

    @Singleton
    @Provides
    fun provideTvShowPopularDao(tmdbDatabase: TMDBDatabase) : TvShowPopularDao {
        return tmdbDatabase.tvShowPopularDao()
    }

    @Singleton
    @Provides
    fun provideArtistPopularDao(tmdbDatabase: TMDBDatabase) : ArtistPopularDao {
        return tmdbDatabase.artistPopularDao()
    }

    @Singleton
    @Provides
    fun provideMovieOnAirDao(tmdbDatabase: TMDBDatabase) : MovieOnAirDao {
        return tmdbDatabase.movieOnAirDao()
    }

    @Singleton
    @Provides
    fun provideTvShowOnAirDao(tmdbDatabase: TMDBDatabase) : TvShowOnAirDao {
        return tmdbDatabase.tvShowOnAirDao()
    }

    @Singleton
    @Provides
    fun provideTrending(tmdbDatabase: TMDBDatabase) : TrendingDao {
        return tmdbDatabase.trendingDao()
    }
}