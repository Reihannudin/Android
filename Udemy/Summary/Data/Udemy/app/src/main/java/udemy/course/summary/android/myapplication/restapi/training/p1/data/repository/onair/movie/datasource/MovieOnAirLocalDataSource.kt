package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir

interface MovieOnAirLocalDataSource {

    suspend fun getMovieOnAirFromDatabase(): List<MovieOnAir>

    suspend fun saveMovieOnAirToDatabase(movieOnAir: List<MovieOnAir>)

    suspend fun deleteAllMovieOnAirFromDatabase()
}