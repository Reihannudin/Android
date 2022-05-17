package udemy.course.android.studycase.myapplication.presentation.di.core.module

import dagger.Module
import dagger.Provides
import udemy.course.android.studycase.myapplication.data.repository.artist.ArtistRepositoryImpl
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistCacheDataSource
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistLocalDataSource
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistRemoteDataSource
import udemy.course.android.studycase.myapplication.data.repository.movie.MoviesRepositoryImpl
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.MovieCacheDataSource
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.MovieLocalDataSource
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.MovieRemoteDataSource
import udemy.course.android.studycase.myapplication.data.repository.tvshow.TvShowRepositoryImpl
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowCacheDataSource
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowLocalDataSource
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowRemoteDataSource
import udemy.course.android.studycase.myapplication.domain.repository.ArtistRepository
import udemy.course.android.studycase.myapplication.domain.repository.MovieRepository
import udemy.course.android.studycase.myapplication.domain.repository.TvShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository{
        return MoviesRepositoryImpl(movieRemoteDataSource,
            movieLocalDataSource,movieCacheDataSource)
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource,
            artistLocalDataSource,artistCacheDataSource)
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDataSource,
            tvShowLocalDataSource,tvShowCacheDataSource)
    }

}