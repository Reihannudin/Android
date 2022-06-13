package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.tvshow

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.TvShowPopularRepository

class UpdateTvShowPopularUseCase(private val tvShowPopularRepository: TvShowPopularRepository) {
    suspend fun execute(): List<TvShowPopular>? = tvShowPopularRepository.updateTvShowPopular()
}