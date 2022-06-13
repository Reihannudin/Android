package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.movie

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.popular.MoviePopularRepository

class UpdateMoviePopularUseCase(private val moviePopularRepository: MoviePopularRepository) {
    suspend fun execute() : List<MoviePopular>? = moviePopularRepository.updateMoviesPopular()
}