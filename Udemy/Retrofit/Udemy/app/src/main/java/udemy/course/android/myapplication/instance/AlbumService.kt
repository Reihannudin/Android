package udemy.course.android.myapplication.instance

import retrofit2.Response
import retrofit2.http.*
import udemy.course.android.myapplication.model.album.Album
import udemy.course.android.myapplication.model.album.AlbumItem

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbum():Response<Album>

//    Query parameters are used to filter the results.
    @GET("/albums")
    suspend fun getSortedAlbum(@Query("userId")userId: Int): Response<Album>

    @GET("/albums/{id}")
    suspend fun getAlbumById(@Path("id")id: Int): Response<AlbumItem>

    @POST("/albums")
    suspend fun uploadAlbum(@Body album:AlbumItem): Response<AlbumItem>
}