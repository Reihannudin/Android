package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.impl

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.Trending
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingCacheDataSource

class TrendingCacheDataSourceImpl : TrendingCacheDataSource{

    private var trendingList = ArrayList<Trending>()

    override suspend fun getTrendingFromCache(): List<Trending> {
        return trendingList
    }

    override suspend fun saveTrendingToCache(trending: List<Trending>) {
        trendingList.clear()
        trendingList = ArrayList(trending)
    }
}