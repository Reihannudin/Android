package udemy.course.summary.android.myapplication.retrofit.training.demo.service

import retrofit2.Response
import retrofit2.http.*
import udemy.course.summary.android.myapplication.retrofit.training.demo.model.Albums
import udemy.course.summary.android.myapplication.retrofit.training.demo.model.AlbumsItem

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums() : Response<Albums>

    @GET("/albums")
    suspend fun getUserId(@Query("userId") userId: Int) : Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbumsId(@Path(value = "id")albumId: Int) : Response<AlbumsItem>

    @POST("/albums")
    suspend fun uploadAlbum(@Body album: AlbumsItem) : Response<AlbumsItem>
}