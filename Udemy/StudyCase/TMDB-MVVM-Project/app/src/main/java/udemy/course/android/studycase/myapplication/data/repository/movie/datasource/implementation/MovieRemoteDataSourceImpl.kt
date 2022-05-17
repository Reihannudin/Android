package udemy.course.android.studycase.myapplication.data.repository.movie.datasource.implementation

import retrofit2.Response
import udemy.course.android.studycase.myapplication.data.api.TMDBService
import udemy.course.android.studycase.myapplication.data.model.movie.MovieList
import udemy.course.android.studycase.myapplication.data.repository.movie.datasource.MovieRemoteDataSource

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}