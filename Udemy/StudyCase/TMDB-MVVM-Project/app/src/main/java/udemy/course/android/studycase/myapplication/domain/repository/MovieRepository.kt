package udemy.course.android.studycase.myapplication.domain.repository

import udemy.course.android.studycase.myapplication.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}