package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular

interface MoviePopularCacheDataSource {

    suspend fun getMoviePopularFromCache(): List<MoviePopular>

    suspend fun saveMoviePopularToCache(moviePopular: List<MoviePopular>)
}