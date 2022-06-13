package udemy.course.summary.android.myapplication.restapi.training.pt1.data.api.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieListOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowListOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistListPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MovieListPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowListPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.TrendingList

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey : String) :
            Response<MovieListPopular>

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey : String) :
            Response<TvShowListPopular>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key") apiKey : String) :
            Response<ArtistListPopular>

    @GET("movie/now_playing")
    suspend fun getOnAirMovie(@Query("api_key") apiKey : String) :
            Response<MovieListOnAir>

    @GET("tv/on_the_air")
    suspend fun getOnAirTvShow(@Query("api_key") apiKey : String) :
            Response<TvShowListOnAir>

    @GET("trending/all/week")
    suspend fun getTrendingFilms(@Query("api_key") apiKey : String) :
            Response<TrendingList>
}