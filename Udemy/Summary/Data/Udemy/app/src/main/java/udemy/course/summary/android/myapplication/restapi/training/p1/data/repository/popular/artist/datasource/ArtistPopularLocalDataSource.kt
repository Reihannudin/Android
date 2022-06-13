package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular

interface ArtistPopularLocalDataSource {

    suspend fun getArtistPopularFromDatabase(): List<ArtistPopular>

    suspend fun saveArtistPopularToDatabase(artistPopular: List<ArtistPopular>)

    suspend fun deleteArtistPopularFromDatabase()
}
