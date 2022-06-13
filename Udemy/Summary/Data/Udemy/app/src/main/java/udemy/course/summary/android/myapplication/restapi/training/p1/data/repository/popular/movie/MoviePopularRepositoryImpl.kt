package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie

import android.util.Log
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularCacheDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.movie.datasource.MoviePopularRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.MoviePopularRepository

class MoviePopularRepositoryImpl(
    private val moviePopularRemoteDataSource: MoviePopularRemoteDataSource,
    private val moviePopularLocalDataSource: MoviePopularLocalDataSource,
    private val moviePopularCacheDataSource: MoviePopularCacheDataSource)
    : MoviePopularRepository {

    override suspend fun getMoviesPopular(): List<MoviePopular>? {
        return getMoviesPopularFromCache()
    }

    override suspend fun updateMoviesPopular(): List<MoviePopular>? {
        val newListOfMoviePopular = getMoviesPopularFromAPI()
        moviePopularLocalDataSource.deleteMoviePopularFromDatabase()
        moviePopularLocalDataSource.saveMoviePopularToDatabase(newListOfMoviePopular)
        moviePopularCacheDataSource.saveMoviePopularToCache(newListOfMoviePopular)
        return newListOfMoviePopular
    }

    //    function get data from API
    suspend fun getMoviesPopularFromAPI() : List<MoviePopular>{
        lateinit var moviesPopularList : List<MoviePopular>
        try{
            val response = moviePopularRemoteDataSource.getMoviePopular()
            val body = response.body()
            if(body != null){
                moviesPopularList = body.moviePopulars
            }
        }catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
        return moviesPopularList
    }

//    function get data from database
    suspend fun getMoviesPopularFromDatabase(): List<MoviePopular>{
        lateinit var moviesPopularList : List<MoviePopular>
        try {
            moviesPopularList = moviePopularLocalDataSource.getMoviePopularFromDatabase()
        }
        catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
    if (moviesPopularList.size > 0){
        return moviesPopularList
    }
    else{
        moviesPopularList = getMoviesPopularFromAPI()
        moviePopularLocalDataSource.saveMoviePopularToDatabase(moviesPopularList)
    }
        return moviesPopularList
    }

//    function get data from cache
    suspend fun getMoviesPopularFromCache(): List<MoviePopular>{
        lateinit var moviesPopularList : List<MoviePopular>
        try {
            moviesPopularList = moviePopularCacheDataSource.getMoviePopularFromCache()
        }
        catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
    if (moviesPopularList.size > 0){
        return moviesPopularList
    }
    else{
        moviesPopularList = getMoviesPopularFromDatabase()
        moviePopularCacheDataSource.saveMoviePopularToCache(moviesPopularList)
    }
        return moviesPopularList
    }
}

