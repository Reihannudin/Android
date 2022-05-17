package udemy.course.android.studycase.myapplication.presentation.di.core.module

import dagger.Module
import dagger.Provides
import udemy.course.android.studycase.myapplication.data.database.dao.ArtistDao
import udemy.course.android.studycase.myapplication.data.database.dao.MovieDao
import udemy.course.android.studycase.myapplication.data.database.dao.TvShowDao
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistLocalDataSource
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.implementation.ArtistLocalDataSourceImpl
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.MovieLocalDataSource
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.implementation.MovieLocalDataSourceImpl
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowLocalDataSource
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.implementation.TvShowLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun providerMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Provides
    @Singleton
    fun providerArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Provides
    @Singleton
    fun providerTvShowLocalDataSource(tvShowDao: TvShowDao) : TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}