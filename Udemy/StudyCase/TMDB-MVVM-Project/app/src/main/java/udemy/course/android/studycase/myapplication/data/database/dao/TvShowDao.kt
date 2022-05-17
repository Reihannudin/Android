package udemy.course.android.studycase.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShow: List<TvShow>)

    @Query("DELETE FROM popular_tvShow")
    suspend fun deleteAllTvShow()

    @Query("SELECT * FROM popular_tvShow")
    suspend fun getTvShows() :List<TvShow>
}