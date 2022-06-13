package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.artist.GetArtistPopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.artist.UpdateArtistPopularUseCase

class ArtistPopularViewModel(
    private val getArtistPopularUseCase: GetArtistPopularUseCase,
    private val updateArtistPopularUseCase: UpdateArtistPopularUseCase
    ) : ViewModel() {

    fun getArtistPopular() = liveData{
        val artistPopularList = getArtistPopularUseCase.execute()
        emit(artistPopularList)
    }

    fun updateArtistPopular() = liveData {
        val artistPopularList = updateArtistPopularUseCase.execute()
        emit(artistPopularList)
    }
}