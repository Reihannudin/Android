package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.impl

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularCacheDataSource

class MoviePopularCacheDataSourceImpl : MoviePopularCacheDataSource {

    private var moviePopularList = ArrayList<MoviePopular>()

    override suspend fun getMoviePopularFromCache(): List<MoviePopular> {
        return moviePopularList
    }

    override suspend fun saveMoviePopularToCache(moviePopular: List<MoviePopular>) {
        moviePopularList.clear()
        moviePopularList = ArrayList(moviePopular)
    }

}