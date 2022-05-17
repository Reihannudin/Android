package udemy.course.android.studycase.myapplication.data.repository.movie.datasource

import udemy.course.android.studycase.myapplication.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)
}