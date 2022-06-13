package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.impl

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieListOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirCacheDataSource

class MovieOnAirCacheDataSourceImpl : MovieOnAirCacheDataSource {

    private var movieOnAirList = ArrayList<MovieOnAir>()

    override suspend fun getMovieOnAirFromCache(): List<MovieOnAir> {
        return movieOnAirList
    }

    override suspend fun saveMovieOnAirToCache(movieOnAir: List<MovieOnAir>) {
        movieOnAirList.clear()
        movieOnAirList = ArrayList(movieOnAir)
    }
}