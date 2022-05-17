package udemy.course.android.studycase.myapplication.data.repository.movie.datasource

import retrofit2.Response
import udemy.course.android.studycase.myapplication.data.model.movie.MovieList

interface MovieRemoteDataSource {

    suspend fun getMovies() : Response<MovieList>
}