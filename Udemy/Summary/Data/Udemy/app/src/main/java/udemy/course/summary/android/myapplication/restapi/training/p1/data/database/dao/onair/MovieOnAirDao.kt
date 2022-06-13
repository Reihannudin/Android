package udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.onair

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir

@Dao
interface MovieOnAirDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieOnAir(movieOnAir: List<MovieOnAir>)

    @Query("SELECT * FROM onair_movie")
    suspend fun getMovieOnAir(): List<MovieOnAir>

    @Query("DELETE FROM onair_movie")
    suspend fun deleteAllMovieOnAir()
}