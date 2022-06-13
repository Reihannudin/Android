package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowOnAir

interface TvShowOnAirLocalDataSource {

    suspend fun getTvShowOnAirFromDatabase(): List<TvShowOnAir>

    suspend fun saveTvShowOnAirToDatabase(tvShowOnAir: List<TvShowOnAir>)

    suspend fun deleteAllTvShowOnAirFromDatabase()

}