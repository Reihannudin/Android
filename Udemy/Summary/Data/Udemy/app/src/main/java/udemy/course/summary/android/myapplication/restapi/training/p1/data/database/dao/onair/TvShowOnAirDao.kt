package udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.onair

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowOnAir

@Dao
interface TvShowOnAirDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShowOnAir(tvShowOnAir: List<TvShowOnAir>)

    @Query("SELECT * FROM onair_tvshow")
    suspend fun getTvShowOnAir(): List<TvShowOnAir>

    @Query("DELETE FROM onair_tvshow")
    suspend fun deleteAllTvShowOnAir()
}