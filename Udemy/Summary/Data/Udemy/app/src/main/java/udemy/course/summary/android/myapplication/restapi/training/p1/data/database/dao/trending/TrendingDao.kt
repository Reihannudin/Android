package udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.trending

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.Trending

@Dao
interface TrendingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTrending(trending: List<Trending>)

    @Query("SELECT * FROM trending_film")
    suspend fun getTrending(): List<Trending>

    @Query("DELETE FROM trending_film")
    suspend fun deleteAllTrending()
}

