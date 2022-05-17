package udemy.course.android.studycase.myapplication.data.api


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import udemy.course.android.studycase.myapplication.data.model.artist.ArtistList
import udemy.course.android.studycase.myapplication.data.model.movie.MovieList
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShowList

interface TMDBService {

    // Get the list of movies
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    // Get the list of tvShow
    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey: String): Response<TvShowList>

    // Get the list of artist
    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key") apiKey: String): Response<ArtistList>

}

