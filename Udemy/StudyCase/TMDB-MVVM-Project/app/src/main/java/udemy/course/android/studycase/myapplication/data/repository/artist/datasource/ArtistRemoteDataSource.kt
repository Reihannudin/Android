package udemy.course.android.studycase.myapplication.data.repository.artist.datasource

import retrofit2.Response
import udemy.course.android.studycase.myapplication.data.model.artist.Artist
import udemy.course.android.studycase.myapplication.data.model.artist.ArtistList

interface ArtistRemoteDataSource {

    suspend fun getArtist() : Response<ArtistList>

}