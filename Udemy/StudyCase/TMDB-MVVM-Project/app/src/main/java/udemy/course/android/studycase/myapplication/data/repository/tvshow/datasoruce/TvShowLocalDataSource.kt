package udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce

import udemy.course.android.studycase.myapplication.data.model.movie.Movie
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowFromDB():List<TvShow>

    suspend fun saveTvShowsToDB(tvShow:List<TvShow>)

    suspend fun clearAll()

}