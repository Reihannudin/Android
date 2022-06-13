package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow

import android.util.Log
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.onair.TvShowOnAirRepository

class TvShowOnAirRepositoryImpl(
    private val tvShowOnAirRemoteDataSource: TvShowOnAirRemoteDataSource,
    private val tvShowOnAirLocalDataSource: TvShowOnAirLocalDataSource,
    private val tvShowOnAirCacheDataSource: TvShowOnAirCacheDataSource
) : TvShowOnAirRepository {

    override suspend fun getTvShowOnAir(): List<TvShowOnAir>? {
        return getTvShowOnAirFromCache()
    }

    override suspend fun updateTvShowOnAir(): List<TvShowOnAir>? {
        val newListOfTvShowOnAir = getTvShowOnAirFromAPI()
        tvShowOnAirLocalDataSource.deleteAllTvShowOnAirFromDatabase()
        tvShowOnAirLocalDataSource.saveTvShowOnAirToDatabase(newListOfTvShowOnAir)
        tvShowOnAirCacheDataSource.saveTvShowOnAirToCache(newListOfTvShowOnAir)
        return newListOfTvShowOnAir
    }

    suspend fun getTvShowOnAirFromAPI() : List<TvShowOnAir>{
        lateinit var tvShowOnAirList : List<TvShowOnAir>
        try {
            val response = tvShowOnAirRemoteDataSource.getTvShowOnAir()
            val body = response.body()
            if (body != null) {
                tvShowOnAirList = body.tvShowOnAirs
            }
        }catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
        return tvShowOnAirList
    }

    suspend fun getTvShowOnAirFromDatabase() : List<TvShowOnAir>{
        lateinit var tvShowOnAirList : List<TvShowOnAir>
        try {
            tvShowOnAirList = tvShowOnAirLocalDataSource.getTvShowOnAirFromDatabase()
        }catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
        if (tvShowOnAirList.size > 0){
            return tvShowOnAirList
        }else{
            tvShowOnAirList = getTvShowOnAirFromAPI()
            tvShowOnAirLocalDataSource.saveTvShowOnAirToDatabase(tvShowOnAirList)
        }
        return tvShowOnAirList
    }

    suspend fun getTvShowOnAirFromCache() : List<TvShowOnAir>{
        lateinit var tvShowOnAirList : List<TvShowOnAir>
        try {
            tvShowOnAirList = tvShowOnAirCacheDataSource.getTvShowOnAirFromCache()
        }catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
        if (tvShowOnAirList.size > 0) {
            return tvShowOnAirList
        } else{
            tvShowOnAirList = getTvShowOnAirFromDatabase()
            tvShowOnAirCacheDataSource.saveTvShowOnAirToCache(tvShowOnAirList)
        }
        return tvShowOnAirList
    }
}