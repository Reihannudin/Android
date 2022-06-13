package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistPopular

interface ArtistPopularCahceDataSource {

    suspend fun getArtistPopularFromCache(): List<ArtistPopular>

    suspend fun saveArtistPopularToCache(artistPopular: List<ArtistPopular>)
}