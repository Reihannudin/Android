package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist

import android.util.Log
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularCahceDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularLocalDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.artist.datasource.ArtistPopularRemoteDataSource
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.ArtistPopularRepository

class ArtistPopularRepositoryImpl(
    private val artistPopularRemoteDataSource: ArtistPopularRemoteDataSource,
    private val artistPopularLocalDataSource: ArtistPopularLocalDataSource,
    private val artistPopularCahceDataSource: ArtistPopularCahceDataSource
) : ArtistPopularRepository {

    override suspend fun getPopularArtists(): List<ArtistPopular>? {
        return getArtistPopularFromCache()
    }

    override suspend fun updatePopularArtists(): List<ArtistPopular>? {
        val newListOfArtistPopular = getArtistPopularFromAPI()
        artistPopularLocalDataSource.deleteArtistPopularFromDatabase()
        artistPopularLocalDataSource.saveArtistPopularToDatabase(newListOfArtistPopular)
        artistPopularCahceDataSource.saveArtistPopularToCache(newListOfArtistPopular)
        return newListOfArtistPopular
    }

    suspend fun getArtistPopularFromAPI(): List<ArtistPopular>{
        lateinit var artistPopularList : List<ArtistPopular>
        try{
            val response = artistPopularRemoteDataSource.getArtistPopular()
            val body = response.body()
            if(body != null){
                artistPopularList = body.artistPopulars
            }
        }catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
        return artistPopularList
    }

    suspend fun getArtistPopularFromDatabase() : List<ArtistPopular>{
        lateinit var artistPopularList : List<ArtistPopular>
        try{
            artistPopularList = artistPopularLocalDataSource.getArtistPopularFromDatabase()

        }catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
        if (artistPopularList.size > 0){
            return artistPopularList
        }
        else{
            artistPopularList = getArtistPopularFromAPI()
            artistPopularLocalDataSource.saveArtistPopularToDatabase(artistPopularList)
        }
        return artistPopularList
    }

    suspend fun getArtistPopularFromCache() : List<ArtistPopular>{
        lateinit var artistPopularList : List<ArtistPopular>
        try{
            artistPopularList = artistPopularCahceDataSource.getArtistPopularFromCache()

        }catch (e: Exception){
            Log.i("MyTag","Error: ${e.message}")
        }
        if (artistPopularList.size > 0){
            return artistPopularList
        }
        else{
            artistPopularList = getArtistPopularFromDatabase()
            artistPopularCahceDataSource.saveArtistPopularToCache(artistPopularList)
        }
        return artistPopularList
    }
}