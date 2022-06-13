package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.tvshow

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.onair.TvShowOnAirRepository

class UpdateTvShowOnAirUseCase(private val tvShowOnAirRepository:TvShowOnAirRepository) {
    suspend fun execute():List<TvShowOnAir>? = tvShowOnAirRepository.updateTvShowOnAir()
}