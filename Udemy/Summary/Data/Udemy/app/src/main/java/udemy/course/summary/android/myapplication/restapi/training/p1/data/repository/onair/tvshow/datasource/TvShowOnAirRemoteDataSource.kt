package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowListOnAir

interface TvShowOnAirRemoteDataSource {

    suspend fun getTvShowOnAir(): Response<TvShowListOnAir>

}