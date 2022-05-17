package udemy.course.android.studycase.myapplication.data.repository.artist.datasource.implementation

import retrofit2.Response
import udemy.course.android.studycase.myapplication.data.api.TMDBService
import udemy.course.android.studycase.myapplication.data.model.artist.Artist
import udemy.course.android.studycase.myapplication.data.model.artist.ArtistList
import udemy.course.android.studycase.myapplication.data.repository.artist.datasource.ArtistRemoteDataSource

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ) : ArtistRemoteDataSource {

    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)
    }
}
