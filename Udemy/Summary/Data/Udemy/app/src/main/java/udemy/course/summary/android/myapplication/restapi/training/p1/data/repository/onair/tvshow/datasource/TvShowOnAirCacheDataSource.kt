package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowOnAir

interface TvShowOnAirCacheDataSource {

    suspend fun getTvShowOnAirFromCache(): List<TvShowOnAir>

    suspend fun saveTvShowOnAirToCache(tvShowOnAir: List<TvShowOnAir>)

}