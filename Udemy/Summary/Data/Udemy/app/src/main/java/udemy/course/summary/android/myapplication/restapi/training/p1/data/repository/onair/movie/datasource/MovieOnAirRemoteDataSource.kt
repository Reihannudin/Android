package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieListOnAir

interface MovieOnAirRemoteDataSource {

    suspend fun getMovieOnAir() : Response<MovieListOnAir>

}