package udemy.course.android.studycase.myapplication.data.repository.artist.datasource

import udemy.course.android.studycase.myapplication.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistFromCache(): List<Artist>

    suspend fun saveArtistToCache(artist: List<Artist>)
}