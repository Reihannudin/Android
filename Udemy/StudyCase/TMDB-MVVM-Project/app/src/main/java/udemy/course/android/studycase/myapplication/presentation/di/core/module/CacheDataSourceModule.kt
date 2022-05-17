package udemy.course.android.studycase.myapplication.presentation.di.core.module

import dagger.Module
import dagger.Provides
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistCacheDataSource
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.implementation.ArtisCacheDataSourceImpl
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.MovieCacheDataSource
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.implementation.MovieCacheDataSourceImpl
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowCacheDataSource
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.implementation.TvShowCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataSourceModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtisCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

}