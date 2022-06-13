package udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular

@Dao
interface MoviePopularDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMoviePopular(moviePopular: List<MoviePopular>)

    @Query("SELECT * FROM popular_movie")
    suspend fun getMoviePopular(): List<MoviePopular>

    @Query("DELETE FROM popular_movie")
    suspend fun deleteAllMoviePopular()
}