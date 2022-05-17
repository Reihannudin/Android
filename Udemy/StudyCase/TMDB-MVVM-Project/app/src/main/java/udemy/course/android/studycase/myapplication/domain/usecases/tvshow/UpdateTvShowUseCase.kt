package udemy.course.android.studycase.myapplication.domain.usecases.tvshow

import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow
import udemy.course.android.studycase.myapplication.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}