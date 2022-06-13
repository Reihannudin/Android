package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.impl

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.api.service.TMDBService
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistListPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularRemoteDataSource

class ArtistPopularRemoteDataSourceImpl
    (private val tmdbService: TMDBService, private val apiKey : String)
    : ArtistPopularRemoteDataSource {

    override suspend fun getArtistPopular(): Response<ArtistListPopular> {
        return tmdbService.getPopularArtist(apiKey)

    }
}