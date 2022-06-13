package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistListPopular

interface ArtistPopularRemoteDataSource {

    suspend fun getArtistPopular() : Response<ArtistListPopular>
}