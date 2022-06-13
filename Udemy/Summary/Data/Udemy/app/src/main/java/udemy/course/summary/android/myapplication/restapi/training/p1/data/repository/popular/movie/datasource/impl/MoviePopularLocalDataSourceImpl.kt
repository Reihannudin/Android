package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.MoviePopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularLocalDataSource

class MoviePopularLocalDataSourceImpl(
    private val moviePopularDao: MoviePopularDao
    ) : MoviePopularLocalDataSource {

    override suspend fun getMoviePopularFromDatabase(): List<MoviePopular> {
        return moviePopularDao.getMoviePopular()
    }

    override suspend fun saveMoviePopularToDatabase(moviePopular: List<MoviePopular>) {
        CoroutineScope(IO).launch {
            moviePopularDao.saveMoviePopular(moviePopular)
        }
    }

    override suspend fun deleteMoviePopularFromDatabase() {
        CoroutineScope(IO).launch {
            moviePopularDao.deleteAllMoviePopular()
        }
    }

}