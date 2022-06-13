package udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular

@Dao
interface TvShowPopularDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShowPopular(tvShowPopular: List<TvShowPopular>)

    @Query("SELECT * FROM popular_tvshow")
    suspend fun getTvShowPopular(): List<TvShowPopular>

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteAllTvShowPopular()

}