package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending

import android.util.Log
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.Trending
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.trending.TrendingRepository

class TrendingRepositoryImpl(
    private val trendingRemoteDataSource: TrendingRemoteDataSource,
    private val trendingLocalDataSource: TrendingLocalDataSource,
    private val trendingCacheDataSource: TrendingCacheDataSource
) : TrendingRepository {

    override suspend fun getTrending(): List<Trending>? {
        return getTrendingFromCache()
    }

    override suspend fun updateTrending(): List<Trending>? {
        val newListOfTrending = getTrendingFromAPI()
        trendingLocalDataSource.deleteAllTrendingFromDatabase()
        trendingLocalDataSource.saveTrendingToDatabase(newListOfTrending)
        trendingCacheDataSource.saveTrendingToCache(newListOfTrending)
        return newListOfTrending
    }

    suspend fun getTrendingFromAPI() : List<Trending>{
        lateinit var trendingList : List<Trending>
        try {
            val response = trendingRemoteDataSource.getTrending()
            val body = response.body()
            if (body != null) {
                trendingList = body.trendings
            }
        }catch (e: Exception){
            Log.i("MyTag", "Error: ${e.message}")
        }
        return trendingList
    }

    suspend fun getTrendingFromDatabase() : List<Trending>{
        lateinit var trendingList : List<Trending>
        try{
            trendingList = trendingLocalDataSource.getTrendingFromDatabase()
        }catch (e: Exception){
            Log.i("MyTag", "Error: ${e.message}")
        }
        if (trendingList.size > 0){
            return trendingList
        }else{
            trendingList = getTrendingFromAPI()
            trendingLocalDataSource.saveTrendingToDatabase(trendingList)
        }
        return trendingList
    }

    suspend fun getTrendingFromCache() : List<Trending>{
        lateinit var trendingList : List<Trending>
        try{
            trendingList = trendingCacheDataSource.getTrendingFromCache()
        }catch (e: Exception){
            Log.i("MyTag", "Error: ${e.message}")
        }
        if (trendingList.size > 0){
            return trendingList
        }else{
            trendingList = getTrendingFromDatabase()
            trendingCacheDataSource.saveTrendingToCache(trendingList)
        }
        return trendingList
    }

}