package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.trending

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.Trending
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.trending.TrendingRepository

class UpdateTrendingUseCase(private val trendingRepository: TrendingRepository) {
    suspend fun execute():List<Trending>? = trendingRepository.updateTrending()
}