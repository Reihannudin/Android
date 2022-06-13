package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow

import android.util.Log
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.TvShowPopularRepository

class TvShowPopularRepositoryImpl(
    private val tvShowPopularRemoteDataSource: TvShowPopularRemoteDataSource,
    private val tvShowPopularLocalDataSource: TvShowPopularLocalDataSource,
    private val tvShowPopularCacheDataSource: TvShowPopularCacheDataSource
) : TvShowPopularRepository {

    override suspend fun getTvShowPopular(): List<TvShowPopular>? {
        return getTvShowPopularFromCache()
    }

    override suspend fun updateTvShowPopular(): List<TvShowPopular>? {
        val newListOfTvShowPopular = getTvShowPopularFromAPI()
        tvShowPopularLocalDataSource.deleteTvShowPopularFromDatabase()
        tvShowPopularLocalDataSource.saveTvShowPopularToDatabase(newListOfTvShowPopular)
        tvShowPopularCacheDataSource.saveTvShowPopularToCache(newListOfTvShowPopular)
        return newListOfTvShowPopular
    }

    suspend fun getTvShowPopularFromAPI() : List<TvShowPopular>{
        lateinit var tvShowPopularList : List<TvShowPopular>
        try{
            val response = tvShowPopularRemoteDataSource.getTvShowPopular()
            val body = response.body()
            if(body != null){
                tvShowPopularList = body.tvShowPopulars
            }
        }catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
        return tvShowPopularList
    }

    //    function get data from database
    suspend fun getTvShowPopularFromDatabase(): List<TvShowPopular>{
        lateinit var tvShowPopularList : List<TvShowPopular>
        try {
            tvShowPopularList = tvShowPopularLocalDataSource.getTvShowPopularFromDatabase()
        }
        catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
        if (tvShowPopularList.size > 0){
            return tvShowPopularList
        }
        else{
            tvShowPopularList = getTvShowPopularFromAPI()
            tvShowPopularLocalDataSource.saveTvShowPopularToDatabase(tvShowPopularList)
        }
        return tvShowPopularList
    }

    //    function get data from cache
    suspend fun getTvShowPopularFromCache(): List<TvShowPopular>{
        lateinit var tvShowPopularList : List<TvShowPopular>
        try {
            tvShowPopularList = tvShowPopularCacheDataSource.getTvShowPopularFromCache()
        }
        catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
        if (tvShowPopularList.size > 0){
            return tvShowPopularList
        }
        else{
            tvShowPopularList= getTvShowPopularFromDatabase()
            tvShowPopularCacheDataSource.saveTvShowPopularToCache(tvShowPopularList)
        }
        return tvShowPopularList
    }


}