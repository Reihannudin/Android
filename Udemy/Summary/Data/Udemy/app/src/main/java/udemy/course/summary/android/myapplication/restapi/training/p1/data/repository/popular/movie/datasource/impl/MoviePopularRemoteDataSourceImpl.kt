package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.impl

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.api.service.TMDBService
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MovieListPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularRemoteDataSource

class MoviePopularRemoteDataSourceImpl (
        private  val tmdbService:TMDBService,
        private val apiKey:String
        ) : MoviePopularRemoteDataSource {

        override suspend fun getMoviePopular(): Response<MovieListPopular> {
                return tmdbService.getPopularMovies(apiKey)
        }

}