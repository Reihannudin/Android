package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.trending.datasource

import retrofit2.Response
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowListPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.TrendingList

interface TrendingRemoteDataSource {

    suspend fun getTrending(): Response<TrendingList>

}