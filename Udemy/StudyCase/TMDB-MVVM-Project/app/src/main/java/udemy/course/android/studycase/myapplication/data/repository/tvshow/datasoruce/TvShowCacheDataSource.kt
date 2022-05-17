package udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce

import udemy.course.android.studycase.myapplication.data.model.movie.Movie
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
//    TvShow
    suspend fun getTvShowFromCache(): List<TvShow>

    suspend fun saveTvShowToCache(tvShow: List<TvShow>)
}