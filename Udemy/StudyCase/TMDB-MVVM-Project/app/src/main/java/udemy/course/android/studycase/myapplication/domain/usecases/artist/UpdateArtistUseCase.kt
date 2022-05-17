package udemy.course.android.studycase.myapplication.domain.usecases.artist

import udemy.course.android.studycase.myapplication.data.model.artist.Artist
import udemy.course.android.studycase.myapplication.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtist()
}