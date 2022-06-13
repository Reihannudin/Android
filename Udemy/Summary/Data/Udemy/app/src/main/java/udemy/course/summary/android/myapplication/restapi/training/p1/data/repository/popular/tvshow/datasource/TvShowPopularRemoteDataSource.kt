package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowListPopular

interface TvShowPopularRemoteDataSource {

    suspend fun getTvShowPopular() : Response<TvShowListPopular>

}