package udemy.course.android.studycase.myapplication.presentation.artist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import udemy.course.android.studycase.myapplication.domain.usecases.artist.GetArtistUseCase
import udemy.course.android.studycase.myapplication.domain.usecases.artist.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {

    fun getArtist() = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}