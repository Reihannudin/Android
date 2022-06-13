package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.trending

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.Trending

interface TrendingRepository {
    suspend fun getTrending(): List<Trending>?
    suspend fun updateTrending() : List<Trending>?
}