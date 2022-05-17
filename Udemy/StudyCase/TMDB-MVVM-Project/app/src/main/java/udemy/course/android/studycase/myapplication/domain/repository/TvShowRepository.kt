package udemy.course.android.studycase.myapplication.domain.repository

import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?

}