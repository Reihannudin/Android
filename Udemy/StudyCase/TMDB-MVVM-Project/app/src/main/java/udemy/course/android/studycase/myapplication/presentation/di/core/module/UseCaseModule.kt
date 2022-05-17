package udemy.course.android.studycase.myapplication.presentation.di.core.module

import dagger.Module
import dagger.Provides
import udemy.course.android.studycase.myapplication.domain.repository.ArtistRepository
import udemy.course.android.studycase.myapplication.domain.repository.MovieRepository
import udemy.course.android.studycase.myapplication.domain.repository.TvShowRepository
import udemy.course.android.studycase.myapplication.domain.usecases.artist.GetArtistUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.artist.UpdateArtistUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.movie.GetMovieUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.movie.UpdateMovieUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.tvshow.GetTvShowUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.tvshow.UpdateTvShowUseCase

@Module
class UseCaseModule {

//    Movie
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMovieUseCase{
        return GetMovieUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }

//    Artist
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }

//    TvShow
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

}