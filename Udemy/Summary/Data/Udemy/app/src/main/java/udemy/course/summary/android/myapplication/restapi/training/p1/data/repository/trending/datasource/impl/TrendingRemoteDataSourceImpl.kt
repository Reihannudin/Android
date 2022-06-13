package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.impl

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.api.service.TMDBService
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.TrendingList
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource.TrendingRemoteDataSource

class TrendingRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey :String)
    : TrendingRemoteDataSource {

    override suspend fun getTrending(): Response<TrendingList> {
        return tmdbService.getTrendingFilms(apiKey)
    }

}