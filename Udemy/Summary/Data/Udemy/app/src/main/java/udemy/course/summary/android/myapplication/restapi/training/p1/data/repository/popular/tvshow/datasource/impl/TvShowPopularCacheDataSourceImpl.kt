package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.impl

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularCacheDataSource

class TvShowPopularCacheDataSourceImpl : TvShowPopularCacheDataSource {

    private var tvShowPopularList = ArrayList<TvShowPopular>()

    override suspend fun getTvShowPopularFromCache(): List<TvShowPopular> {
        return tvShowPopularList
    }

    override suspend fun saveTvShowPopularToCache(tvShowPopular: List<TvShowPopular>) {
        tvShowPopularList.clear()
        tvShowPopularList = ArrayList(tvShowPopular)
    }
}