package udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce

import retrofit2.Response
import udemy.course.android.studycase.myapplication.data.model.movie.MovieList
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShowList

interface TvShowRemoteDataSource {
    suspend fun getTvShow() : Response<TvShowList>

}