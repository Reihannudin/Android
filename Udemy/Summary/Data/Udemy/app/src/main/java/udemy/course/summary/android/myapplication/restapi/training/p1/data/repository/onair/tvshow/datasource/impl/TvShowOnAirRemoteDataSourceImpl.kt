package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.impl

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.api.service.TMDBService
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowListOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirRemoteDataSource

class TvShowOnAirRemoteDataSourceImpl(private val tmdbService: TMDBService , private val apiKey :String)
    : TvShowOnAirRemoteDataSource {

    override suspend fun getTvShowOnAir(): Response<TvShowListOnAir> {
        return tmdbService.getOnAirTvShow(apiKey)
    }

}