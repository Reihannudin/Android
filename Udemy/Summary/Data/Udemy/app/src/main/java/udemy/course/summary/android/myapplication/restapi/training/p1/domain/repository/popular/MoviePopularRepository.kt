package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular

interface MoviePopularRepository {
    suspend fun getMoviesPopular(): List<MoviePopular>?
    suspend fun updateMoviesPopular(): List<MoviePopular>?
}