package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.onair.TvShowOnAirDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.onair.tvshow.datasource.TvShowOnAirLocalDataSource

class TvShowOnAirLocalDataSourceImpl(private val tvShowOnAirDao: TvShowOnAirDao)
    : TvShowOnAirLocalDataSource{

    override suspend fun getTvShowOnAirFromDatabase(): List<TvShowOnAir> {
        return tvShowOnAirDao.getTvShowOnAir()
    }

    override suspend fun saveTvShowOnAirToDatabase(tvShowOnAir: List<TvShowOnAir>) {
        CoroutineScope(IO).launch {
            tvShowOnAirDao.saveTvShowOnAir(tvShowOnAir)
        }
    }

    override suspend fun deleteAllTvShowOnAirFromDatabase() {
        CoroutineScope(IO).launch {
            tvShowOnAirDao.deleteAllTvShowOnAir()
        }
    }

}