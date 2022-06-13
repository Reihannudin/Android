package udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.onair.movie

import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.repository.onair.MovieOnAirRepository

class UpdateMovieOnAirUseCase(private val movieOnAirRepository: MovieOnAirRepository) {
    suspend fun execute() : List<MovieOnAir>? = movieOnAirRepository.updateMovieOnAir()
}