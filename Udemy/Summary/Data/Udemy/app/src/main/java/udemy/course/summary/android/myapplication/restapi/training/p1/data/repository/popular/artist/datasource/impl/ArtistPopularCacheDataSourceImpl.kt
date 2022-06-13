package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.impl

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularCahceDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularLocalDataSource

class ArtistPopularCacheDataSourceImpl :ArtistPopularCahceDataSource{

    private var artistPopularList = ArrayList<ArtistPopular>()

    override suspend fun getArtistPopularFromCache(): List<ArtistPopular> {
        return artistPopularList
    }

    override suspend fun saveArtistPopularToCache(artistPopular: List<ArtistPopular>) {
        artistPopularList.clear()
        artistPopularList = ArrayList(artistPopular)
    }
}