package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.onair.MovieOnAirDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirLocalDataSource

class MovieOnAirLocalDataSourceImpl(private val movieOnAirDao: MovieOnAirDao)
    : MovieOnAirLocalDataSource {

    override suspend fun getMovieOnAirFromDatabase(): List<MovieOnAir> {
        return movieOnAirDao.getMovieOnAir()
    }

    override suspend fun saveMovieOnAirToDatabase(movieOnAir: List<MovieOnAir>) {
        CoroutineScope(IO).launch {
            movieOnAirDao.saveMovieOnAir(movieOnAir)
        }
    }

    override suspend fun deleteAllMovieOnAirFromDatabase() {
        CoroutineScope(IO).launch {
            movieOnAirDao.deleteAllMovieOnAir()
        }
    }
}