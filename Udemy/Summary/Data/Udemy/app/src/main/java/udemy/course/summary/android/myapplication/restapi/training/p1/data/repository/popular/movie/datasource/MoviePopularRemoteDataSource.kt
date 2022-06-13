package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MovieListPopular

interface MoviePopularRemoteDataSource {

    suspend fun getMoviePopular() : Response<MovieListPopular>

}