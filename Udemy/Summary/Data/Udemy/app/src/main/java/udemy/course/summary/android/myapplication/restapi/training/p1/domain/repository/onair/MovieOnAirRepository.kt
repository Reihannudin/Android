package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.onair

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir

interface MovieOnAirRepository {
    suspend fun getMovieOnAir(): List<MovieOnAir>?
    suspend fun updateMovieOnAir(): List<MovieOnAir>?
}