package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.TvShowPopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource.TvShowPopularLocalDataSource

class TvShowPopularLocalDataSourceImpl(
    private val tvShowPopularDao: TvShowPopularDao
) : TvShowPopularLocalDataSource {

    override suspend fun getTvShowPopularFromDatabase(): List<TvShowPopular> {
        return tvShowPopularDao.getTvShowPopular()
    }

    override suspend fun saveTvShowPopularToDatabase(tvShowPopular: List<TvShowPopular>) {
        CoroutineScope(IO).launch {
            tvShowPopularDao.saveTvShowPopular(tvShowPopular)
        }
    }

    override suspend fun deleteTvShowPopularFromDatabase() {
        CoroutineScope(IO).launch {
            tvShowPopularDao.deleteAllTvShowPopular()
        }
    }

}