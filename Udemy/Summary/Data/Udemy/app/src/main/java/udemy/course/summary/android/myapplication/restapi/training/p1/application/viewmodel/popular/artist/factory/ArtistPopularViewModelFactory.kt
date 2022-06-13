package udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.artist.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.artist.ArtistPopularViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.artist.GetArtistPopularUseCase
import udemy.course.summary.android.myapplication.restapi.training.pt1.domain.usecase.popular.artist.UpdateArtistPopularUseCase

class ArtistPopularViewModelFactory(
    private val getArtistPopularUseCase: GetArtistPopularUseCase,
    private val updateArtistPopularUseCase: UpdateArtistPopularUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistPopularViewModel(getArtistPopularUseCase, updateArtistPopularUseCase) as T
    }
}