package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.impl

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirCacheDataSource

class TvShowOnAirCacheDataSourceImpl : TvShowOnAirCacheDataSource {

    private var tvShowOnAirList = ArrayList<TvShowOnAir>()

    override suspend fun getTvShowOnAirFromCache(): List<TvShowOnAir> {
        return tvShowOnAirList
    }

    override suspend fun saveTvShowOnAirToCache(tvShowOnAir: List<TvShowOnAir>) {
        tvShowOnAirList.clear()
        tvShowOnAirList = ArrayList(tvShowOnAir)
    }

}