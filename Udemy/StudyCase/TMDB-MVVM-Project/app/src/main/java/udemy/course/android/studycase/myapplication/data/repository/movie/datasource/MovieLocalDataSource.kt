package udemy.course.android.studycase.myapplication.data.repository.movie.datasource

import udemy.course.android.studycase.myapplication.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB():List<Movie>

    suspend fun saveMoviesToDB(movies:List<Movie>)

    suspend fun clearAll()
}