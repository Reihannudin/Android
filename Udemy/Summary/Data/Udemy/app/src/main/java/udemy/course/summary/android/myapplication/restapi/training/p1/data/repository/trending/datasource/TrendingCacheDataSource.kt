package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.Trending

interface TrendingCacheDataSource {

    suspend fun getTrendingFromCache(): List<Trending>

    suspend fun saveTrendingToCache(trending: List<Trending>)

}