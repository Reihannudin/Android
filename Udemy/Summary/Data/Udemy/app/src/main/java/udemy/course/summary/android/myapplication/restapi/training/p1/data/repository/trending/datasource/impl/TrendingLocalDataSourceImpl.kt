package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.trending.TrendingDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.Trending
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingLocalDataSource

class TrendingLocalDataSourceImpl(private val trendingDao: TrendingDao)
    : TrendingLocalDataSource {

    override suspend fun getTrendingFromDatabase(): List<Trending> {
        return trendingDao.getTrending()
    }

    override suspend fun saveTrendingToDatabase(trending: List<Trending>) {
        CoroutineScope(IO).launch {
            trendingDao.saveTrending(trending)
        }
    }

    override suspend fun deleteAllTrendingFromDatabase() {
        CoroutineScope(IO).launch {
            trendingDao.deleteAllTrending()
        }
    }
}