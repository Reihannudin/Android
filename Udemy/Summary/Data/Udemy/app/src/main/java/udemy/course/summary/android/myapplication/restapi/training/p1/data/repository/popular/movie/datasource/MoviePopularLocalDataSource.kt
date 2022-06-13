package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular

interface MoviePopularLocalDataSource {

    suspend fun getMoviePopularFromDatabase():List<MoviePopular>

    suspend fun saveMoviePopularToDatabase(moviePopular: List<MoviePopular>)

    suspend fun deleteMoviePopularFromDatabase()
}