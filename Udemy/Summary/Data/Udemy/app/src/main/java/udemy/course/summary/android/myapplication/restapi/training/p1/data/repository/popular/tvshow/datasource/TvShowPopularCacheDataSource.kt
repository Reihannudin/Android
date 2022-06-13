package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular

interface TvShowPopularCacheDataSource {

    suspend fun getTvShowPopularFromCache(): List<TvShowPopular>

    suspend fun saveTvShowPopularToCache(tvShowPopular: List<TvShowPopular>)
}