package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir

interface MovieOnAirCacheDataSource {

    suspend fun getMovieOnAirFromCache(): List<MovieOnAir>

    suspend fun saveMovieOnAirToCache(movieOnAir: List<MovieOnAir>)
}