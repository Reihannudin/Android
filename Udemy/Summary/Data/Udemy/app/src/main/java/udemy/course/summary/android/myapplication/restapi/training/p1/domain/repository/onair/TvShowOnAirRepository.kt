package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.onair

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowOnAir

interface TvShowOnAirRepository {
    suspend fun getTvShowOnAir(): List<TvShowOnAir>?
    suspend fun updateTvShowOnAir() : List<TvShowOnAir>?
}