package udemy.course.android.studycase.myapplication.data.repository.movie

import android.util.Log
import udemy.course.android.studycase.myapplication.data.model.movie.Movie
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.MovieCacheDataSource
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.MovieLocalDataSource
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.MovieRemoteDataSource
import udemy.course.android.studycase.myapplication.domain.repository.MovieRepository

class MoviesRepositoryImpl
    (private val movieRemoteDataSource : MovieRemoteDataSource,
     private val movieLocalDataSource: MovieLocalDataSource,
     private val movieCacheDataSource: MovieCacheDataSource
     ): MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovie = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovie)
        movieCacheDataSource.saveMoviesToCache(newListOfMovie)
        return newListOfMovie
    }

//    function get data from API
    suspend fun getMoviesFromAPI() : List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.i("MyTag",  e.message.toString())
        }
        return movieList
    }

//    function get data from local database
    suspend fun getMoviesFromLocalDB(): List<Movie>{
        lateinit var movieList : List<Movie>
        try{
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (e: Exception){
            Log.i("MyTag", e.message.toString())
        }

        if (movieList.size > 0){
            return movieList
        } else{
            movieList= getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }


//    function get data from cache database
    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList : List<Movie>
        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e: Exception){
            Log.i("MyTag", e.message.toString())
        }

        if (movieList.size > 0){
            return movieList
        } else{
            movieList = getMoviesFromLocalDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}