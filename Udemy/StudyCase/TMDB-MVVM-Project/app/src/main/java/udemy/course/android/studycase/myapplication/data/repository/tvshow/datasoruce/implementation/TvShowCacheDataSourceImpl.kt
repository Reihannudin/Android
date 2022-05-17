package udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.implementation

import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}
