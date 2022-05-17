package udemy.course.android.studycase.myapplication.data.repository.tvshow

import android.util.Log
import udemy.course.android.studycase.myapplication.data.model.movie.Movie
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowCacheDataSource
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowLocalDataSource
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowRemoteDataSource
import udemy.course.android.studycase.myapplication.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {

    private var Tag = "MyTag"

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShow = getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }

    //    function get data from API
    suspend fun getTvShowFromAPI() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShow()
            val body = response.body()
            if(body != null){
                tvShowList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i(Tag,  e.message.toString())
        }
        return tvShowList
    }


    //    function get data from local db
    suspend fun getTvShowFromLocalDB() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try{
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        }catch (e: Exception){
            Log.i(Tag, e.message.toString())
        }

        if (tvShowList.size > 0){
            return tvShowList
        } else{
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }


    //    function get data from cache
    suspend fun getTvShowFromCache() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try{
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        }catch (e: Exception){
            Log.i(Tag, e.message.toString())
        }

        if (tvShowList.size > 0){
            return tvShowList
        } else{
            tvShowList = getTvShowFromLocalDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }

        return tvShowList
    }

}