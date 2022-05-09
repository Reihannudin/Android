package udemy.course.android.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response
import retrofit2.create
import udemy.course.android.myapplication.instance.AlbumService
import udemy.course.android.myapplication.instance.RetrofitInstance
import udemy.course.android.myapplication.model.album.Album
import udemy.course.android.myapplication.model.album.AlbumItem

class MainActivity : AppCompatActivity() {

    private val Tag = "MyAPP"

    private lateinit var retService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        set retrofit service
        retService = RetrofitInstance.getRetrofitInstance()
            .create(AlbumService::class.java)
        getRequestQuerywithParameters()
        getRequestQueryPathParameters()
        uploadAlbum()

    }

    private fun getRequestQuerywithParameters(){
        //        make response as  Live data
        val responeLiveData : LiveData<Response<Album>> = liveData {
            val respone = retService.getSortedAlbum(4)
            emit(respone)
        }
//        make get response from live data
        responeLiveData.observe(this, Observer{
            val albumList = it.body()?.listIterator()
            if(albumList!=null){
                while(albumList.hasNext()){
                    val albumItems = albumList.next()
//                    Log.i(Tag, albumItems.title)
                    val result = " "+"Album Title: ${albumItems.title}\n"+
                            "Album Id: ${albumItems.id}\n" +
                            "User Id: ${albumItems.userId}\n\n\n"
                    val textView = findViewById<TextView>(R.id.tv_rest_data)
                    textView.append(result)
                }
            }
        })
    }

    private fun getRequestQueryPathParameters(){
        val pathResponseLiveData : LiveData<Response<AlbumItem>> = liveData {
            val pathResponse = retService.getAlbumById(3)
            emit(pathResponse)
        }
        pathResponseLiveData.observe(this, Observer {
            val data = it.body()?.id
            Toast.makeText(applicationContext, "Album Id: ${data}", Toast.LENGTH_LONG).show()
        })
    }

    private fun uploadAlbum(){
        val album = AlbumItem(1, "My title",4)
        val postRespone : LiveData<Response<AlbumItem>> = liveData{
            val response = retService.uploadAlbum(album)
            emit(response)
        }

        postRespone.observe(this , Observer {
            val recivedAlbumItem = it.body()
            val result = "Album Id: ${recivedAlbumItem?.id}\n" +
                    "Album Title: ${recivedAlbumItem?.title}\n" +
                    "User Id: ${recivedAlbumItem?.userId}\n\n\n"
            val textView = findViewById<TextView>(R.id.tv_rest_data)
            textView.append(result)
        })
    }
}