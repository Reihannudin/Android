package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.ArtistPopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularLocalDataSource

class ArtistPopularLocalDataSourceImpl(private val artistPopularDao: ArtistPopularDao)
    : ArtistPopularLocalDataSource {

    override suspend fun getArtistPopularFromDatabase(): List<ArtistPopular> {
        return artistPopularDao.getArtistPopular()
    }

    override suspend fun saveArtistPopularToDatabase(artistPopular: List<ArtistPopular>) {
        CoroutineScope(IO).launch {
            artistPopularDao.saveArtistPopular(artistPopular)
        }
    }

    override suspend fun deleteArtistPopularFromDatabase() {
        CoroutineScope(IO).launch {
            artistPopularDao.deleteAllArtistPopular()
        }
    }
}