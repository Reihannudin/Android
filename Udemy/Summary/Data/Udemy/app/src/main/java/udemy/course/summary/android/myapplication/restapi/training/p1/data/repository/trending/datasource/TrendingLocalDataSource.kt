package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.Trending

interface TrendingLocalDataSource {

    suspend fun getTrendingFromDatabase() : List<Trending>

    suspend fun saveTrendingToDatabase(trending: List<Trending>)

    suspend fun deleteAllTrendingFromDatabase()
}