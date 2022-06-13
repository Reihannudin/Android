package udemy.course.summary.android.myapplication.restapi.training.pt1.data.repository.popular.tvshow.datasource

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular

interface TvShowPopularLocalDataSource {

    suspend fun getTvShowPopularFromDatabase():List<TvShowPopular>

    suspend fun saveTvShowPopularToDatabase(tvShowPopular: List<TvShowPopular>)

    suspend fun deleteTvShowPopularFromDatabase()
}