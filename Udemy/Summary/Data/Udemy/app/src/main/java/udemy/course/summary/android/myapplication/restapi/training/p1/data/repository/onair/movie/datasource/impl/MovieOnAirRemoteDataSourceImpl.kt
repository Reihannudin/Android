package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.impl

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.api.service.TMDBService
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieListOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirRemoteDataSource

class MovieOnAirRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey :String)
    : MovieOnAirRemoteDataSource {

    override suspend fun getMovieOnAir(): Response<MovieListOnAir> {
        return tmdbService.getOnAirMovie(apiKey)
    }

}