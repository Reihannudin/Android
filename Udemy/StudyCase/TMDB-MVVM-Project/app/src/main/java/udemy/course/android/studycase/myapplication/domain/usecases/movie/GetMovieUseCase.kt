package udemy.course.android.studycase.myapplication.domain.usecases.movie

import udemy.course.android.studycase.myapplication.data.model.movie.Movie
import udemy.course.android.studycase.myapplication.domain.repository.MovieRepository

class GetMovieUseCase(private val moviesRepository : MovieRepository) {
    suspend fun execute():List<Movie>? = moviesRepository.getMovies()
}