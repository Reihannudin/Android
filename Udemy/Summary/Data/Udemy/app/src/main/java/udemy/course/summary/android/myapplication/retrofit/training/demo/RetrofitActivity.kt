package udemy.course.summary.android.myapplication.retrofit.training.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.ActivityRetrofitBinding
import udemy.course.summary.android.myapplication.retrofit.training.demo.instance.RetrofitInstance
import udemy.course.summary.android.myapplication.retrofit.training.demo.model.Albums
import udemy.course.summary.android.myapplication.retrofit.training.demo.model.AlbumsItem
import udemy.course.summary.android.myapplication.retrofit.training.demo.service.AlbumService

class RetrofitActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRetrofitBinding
    private lateinit var retrofitService : AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)

        retrofitService = RetrofitInstance.getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData : LiveData<Response<Albums>> = liveData{
            val response = retrofitService.getAlbums()
            emit(response)
        }

        postRequestParameter()
//        getRequestWithQueryParameter()
//        getRequestWithPathParameter()
    }

    private fun postRequestParameter(){
        val album = AlbumsItem(0, "MyTitle", 3)
        val postRequest : LiveData<Response<AlbumsItem>> = liveData {
            val response = retrofitService.uploadAlbum(album)
            emit(response)
        }
        postRequest.observe(this, Observer{
            val recievedAlbumItem = it.body()
            val result = " "+"Album Id : ${recievedAlbumItem?.id}"+"\n"
                         " "+"Album Title : ${recievedAlbumItem?.title}"+"\n"
                         " "+"Album User Id : ${recievedAlbumItem?.userId}"+"\n\n\n"
            binding.tvRestData.text = result
        })
    }

    private fun getRequestWithQueryParameter(){

        val responseLiveData : LiveData<Response<Albums>> = liveData {
            val response = retrofitService.getUserId(2)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumList = albumList.next()
                    val result = " "+"Album Id : ${albumList.id}"+"\n"
                    " "+"Album Title : ${albumList.title}"+"\n"
                    " "+"Album User Id : ${albumList.userId}"+"\n\n\n"
                    binding.tvRestData.append(result)
//                    Log.i("MyTag", albumList.title)
                }
            }
        })
    }

    private fun getRequestWithPathParameter(){

        val pathLiveData : LiveData<Response<AlbumsItem>> = liveData{
            val response = retrofitService.getAlbumsId(3)
            emit(response)
        }
        pathLiveData.observe(this, Observer{
            val title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }
}