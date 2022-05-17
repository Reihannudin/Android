package udemy.course.android.studycase.myapplication.domain.repository

import udemy.course.android.studycase.myapplication.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}