package udemy.course.android.studycase.myapplication.presentation.di.core.module

import dagger.Module
import dagger.Provides
import udemy.course.android.studycase.myapplication.data.api.TMDBService
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistRemoteDataSource
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.implementation.ArtistRemoteDataSourceImpl
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.MovieRemoteDataSource
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.implementation.MovieRemoteDataSourceImpl
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowRemoteDataSource
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.implementation.TvShowRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataSourceModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun providerMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Provides
    @Singleton
    fun providerArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Provides
    @Singleton
    fun providerTvShowRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdbService,apiKey)
    }
}