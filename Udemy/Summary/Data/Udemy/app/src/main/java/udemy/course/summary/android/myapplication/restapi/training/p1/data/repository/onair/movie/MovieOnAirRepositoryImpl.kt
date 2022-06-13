package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie

import android.util.Log
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.movie.datasource.MovieOnAirRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.onair.MovieOnAirRepository

class MovieOnAirRepositoryImpl (
    private val movieOnAirRemoteDataSource: MovieOnAirRemoteDataSource,
    private val movieOnAirLocalDataSource: MovieOnAirLocalDataSource,
    private val movieOnAirCacheDataSource: MovieOnAirCacheDataSource
        ): MovieOnAirRepository {

    override suspend fun getMovieOnAir(): List<MovieOnAir>? {
        return getMovieOnAirFromCache()
    }

    override suspend fun updateMovieOnAir(): List<MovieOnAir>? {
        val newLisOftMovieOnAir = getMovieOnAirFromAPI()
        movieOnAirLocalDataSource.deleteAllMovieOnAirFromDatabase()
        movieOnAirLocalDataSource.saveMovieOnAirToDatabase(newLisOftMovieOnAir)
        movieOnAirCacheDataSource.saveMovieOnAirToCache(newLisOftMovieOnAir)
        return newLisOftMovieOnAir
    }

    suspend fun getMovieOnAirFromAPI(): List<MovieOnAir>{
        lateinit var movieOnAirList: List<MovieOnAir>
        try{
            val response = movieOnAirRemoteDataSource.getMovieOnAir()
            val body = response.body()
            if (body != null) {
                movieOnAirList = body.movieOnAirs
            }
        } catch (e: Exception) {
            Log.i("MyTag","Error: ${e.message}")
        }
        return movieOnAirList
    }

    suspend fun getMovieOnAirFromDatabase(): List<MovieOnAir>{
        lateinit var movieOnAirList : List<MovieOnAir>
        try{
            movieOnAirList = movieOnAirLocalDataSource.getMovieOnAirFromDatabase()
        } catch (e: Exception) {
            Log.i("MyTag","Error: ${e.message}")
        }
        if (movieOnAirList.size > 0 ){
            return movieOnAirList
        }else{
            movieOnAirList = getMovieOnAirFromAPI()
            movieOnAirLocalDataSource.saveMovieOnAirToDatabase(movieOnAirList)
        }
        return movieOnAirList
    }

    suspend fun getMovieOnAirFromCache() : List<MovieOnAir>{
        lateinit var movieOnAirList : List<MovieOnAir>
        try{
            movieOnAirList = movieOnAirCacheDataSource.getMovieOnAirFromCache()
        } catch (e: Exception) {
            Log.i("MyTag","Error: ${e.message}")
        }
        if (movieOnAirList.size > 0 ) {
            return movieOnAirList
        }else{
            movieOnAirList = getMovieOnAirFromDatabase()
            movieOnAirCacheDataSource.saveMovieOnAirToCache(movieOnAirList)
        }
        return movieOnAirList
    }
}