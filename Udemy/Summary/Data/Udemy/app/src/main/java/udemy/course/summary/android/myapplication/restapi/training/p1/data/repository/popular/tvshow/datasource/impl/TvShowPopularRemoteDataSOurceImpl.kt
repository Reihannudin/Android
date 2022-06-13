package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.impl

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.api.service.TMDBService
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowListPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularRemoteDataSource

class TvShowPopularRemoteDataSOurceImpl(
    private  val tmdbService: TMDBService,
    private val apiKey:String
) : TvShowPopularRemoteDataSource {

    override suspend fun getTvShowPopular(): Response<TvShowListPopular> {
        return tmdbService.getPopularTvShow(apiKey)
    }

}