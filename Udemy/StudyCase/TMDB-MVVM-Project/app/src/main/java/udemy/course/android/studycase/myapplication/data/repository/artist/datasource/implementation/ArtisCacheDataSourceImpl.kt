package udemy.course.android.studycase.myapplication.data.repository.artist.datasource.implementation

import udemy.course.android.studycase.myapplication.data.model.artist.Artist
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistCacheDataSource

class ArtisCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}