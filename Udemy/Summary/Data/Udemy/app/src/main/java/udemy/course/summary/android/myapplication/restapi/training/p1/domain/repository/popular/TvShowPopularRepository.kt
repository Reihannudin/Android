package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular

interface TvShowPopularRepository {
    suspend fun getTvShowPopular(): List<TvShowPopular>?
    suspend fun updateTvShowPopular() : List<TvShowPopular>?
}