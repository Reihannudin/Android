package udemy.course.android.studycase.myapplication.data.repository.artist

import android.util.Log
import udemy.course.android.studycase.myapplication.data.model.artist.Artist
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistCacheDataSource
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistLocalDataSource
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistRemoteDataSource
import udemy.course.android.studycase.myapplication.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    private var Tag = "MyTag"

    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListArtist = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListArtist)
        artistCacheDataSource.saveArtistToCache(newListArtist)
        return newListArtist
    }

    //    function get data from API
    suspend fun getArtistFromAPI() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if(body != null){
                artistList = body.artists
            }
        } catch (e: Exception) {
            Log.i(Tag,  e.message.toString())
        }
        return artistList
    }

    //    function get data from local database
    suspend fun getArtistFromLocal() : List<Artist> {
        lateinit var artistList: List<Artist>
        try{
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (e: Exception){
            Log.i(Tag, e.message.toString())
        }

        if (artistList.size > 0){
            return artistList
        } else{
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    //    function get data from cache database
    suspend fun getArtistFromCache() : List<Artist> {
        lateinit var artistList: List<Artist>
        try{
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch (e: Exception){
            Log.i(Tag, e.message.toString())
        }

        if (artistList.size > 0){
            return artistList
        } else{
            artistList = getArtistFromLocal()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}