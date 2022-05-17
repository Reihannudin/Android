package udemy.course.android.studycase.myapplication.presentation.artist.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.studycase.myapplication.domain.usecases.artist.GetArtistUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.artist.UpdateArtistUseCase
import udemy.course.android.studycase.myapplication.presentation.artist.viewmodel.ArtistViewModel
import udemy.course.android.studycase.myapplication.presentation.movie.viewmodel.MovieViewModel

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase, updateArtistUseCase) as T
    }
}