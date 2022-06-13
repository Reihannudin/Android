package udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistPopular

@Dao
interface ArtistPopularDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtistPopular(artistPopular: List<ArtistPopular>)

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtistPopular(): List<ArtistPopular>

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllArtistPopular()
}