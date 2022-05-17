package udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.implementation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import udemy.course.android.studycase.myapplication.data.database.dao.TvShowDao
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowLocalDataSource

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {

    override suspend fun getTvShowFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShow: List<TvShow>) {
        CoroutineScope(IO).launch {
            tvShowDao.saveTvShow(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            tvShowDao.deleteAllTvShow()
        }
    }
}