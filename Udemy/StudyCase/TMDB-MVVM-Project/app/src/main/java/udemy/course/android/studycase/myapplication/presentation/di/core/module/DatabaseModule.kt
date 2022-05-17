package udemy.course.android.studycase.myapplication.presentation.di.core.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import udemy.course.android.studycase.myapplication.data.database.dao.ArtistDao
import udemy.course.android.studycase.myapplication.data.database.dao.MovieDao
import udemy.course.android.studycase.myapplication.data.database.dao.TvShowDao
import udemy.course.android.studycase.myapplication.data.database.room.TMDBDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providerMovieDataBase(context : Context) : TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbClient")
            .build()
    }

    @Singleton
    @Provides
    fun providerMovieDao(tmdbDatabase : TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun providerArtistDao(tmdbDatabase : TMDBDatabase): ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun providerTvShowDao(tmmdbDatabase: TMDBDatabase): TvShowDao {
        return tmmdbDatabase.tvShowDao()
    }
}