package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.artist

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.ArtistPopularRepository

class UpdateArtistPopularUseCase(private val artistPopularRepository: ArtistPopularRepository) {
    suspend fun execute():List<ArtistPopular>? = artistPopularRepository.updatePopularArtists()
}