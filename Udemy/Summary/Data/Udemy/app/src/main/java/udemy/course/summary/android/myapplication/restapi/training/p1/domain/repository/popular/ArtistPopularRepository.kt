package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistPopular

interface ArtistPopularRepository {
    suspend fun getPopularArtists(): List<ArtistPopular>?
    suspend fun updatePopularArtists() : List<ArtistPopular>?
}