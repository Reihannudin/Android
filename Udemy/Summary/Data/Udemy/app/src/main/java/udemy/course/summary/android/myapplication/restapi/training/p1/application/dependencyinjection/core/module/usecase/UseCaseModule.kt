package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.usecase

import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.onair.MovieOnAirRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.onair.TvShowOnAirRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.ArtistPopularRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.MoviePopularRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.TvShowPopularRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.trending.TrendingRepository
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.movie.GetMovieOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.movie.UpdateMovieOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.tvshow.GetTVShowOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.tvshow.UpdateTvShowOnAirUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.artist.GetArtistPopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.artist.UpdateArtistPopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.movie.GetMoviePopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.movie.UpdateMoviePopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.tvshow.GetTvShowPopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.tvshow.UpdateTvShowPopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.trending.GetTrendingUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.trending.UpdateTrendingUseCase

@Module
class UseCaseModule {

    @Provides
    fun provideGetMoviePopularUseCase(moviePopularRepository: MoviePopularRepository): GetMoviePopularUseCase {
        return GetMoviePopularUseCase(moviePopularRepository)
    }
    @Provides
    fun provideUpdateMoviePopularUseCase(moviePopularRepository: MoviePopularRepository): UpdateMoviePopularUseCase {
        return UpdateMoviePopularUseCase(moviePopularRepository)
    }

    @Provides
    fun provideGetTvShowPopularUseCase(tvShowPopularRepository: TvShowPopularRepository): GetTvShowPopularUseCase {
        return GetTvShowPopularUseCase(tvShowPopularRepository)
    }
    @Provides
    fun provideUpdateTvShowPopularUseCase(tvShowPopularRepository: TvShowPopularRepository): UpdateTvShowPopularUseCase {
        return UpdateTvShowPopularUseCase(tvShowPopularRepository)
    }

    @Provides
    fun provideGetArtistPopularUseCase(artistPopularRepository: ArtistPopularRepository): GetArtistPopularUseCase {
        return GetArtistPopularUseCase(artistPopularRepository)
    }
    @Provides
    fun provideUpdateArtistPopularUseCase(artistPopularRepository: ArtistPopularRepository): UpdateArtistPopularUseCase {
        return UpdateArtistPopularUseCase(artistPopularRepository)
    }

    @Provides
    fun provideGetMovieOnAirUseCase(movieOnAirRepository: MovieOnAirRepository): GetMovieOnAirUseCase {
        return GetMovieOnAirUseCase(movieOnAirRepository)
    }
    @Provides
    fun provideUpdateMovieOnAirUSeCase(movieOnAirRepository: MovieOnAirRepository): UpdateMovieOnAirUseCase {
        return UpdateMovieOnAirUseCase(movieOnAirRepository)
    }

    @Provides
    fun provideGetTvShowOnAirUseCase(tvShowOnAirRepository: TvShowOnAirRepository): GetTVShowOnAirUseCase {
        return GetTVShowOnAirUseCase(tvShowOnAirRepository)
    }
    @Provides
    fun provideUpdateTvShowOnAirUseCase(tvShowOnAirRepository: TvShowOnAirRepository): UpdateTvShowOnAirUseCase {
        return UpdateTvShowOnAirUseCase(tvShowOnAirRepository)
    }

    @Provides
    fun provideGetTrendingUseCase(trendingRepository : TrendingRepository): GetTrendingUseCase {
        return GetTrendingUseCase(trendingRepository)
    }
    @Provides
    fun provideUpdateTrendingUseCase(trendingRepository : TrendingRepository): UpdateTrendingUseCase {
        return UpdateTrendingUseCase(trendingRepository)
    }
}