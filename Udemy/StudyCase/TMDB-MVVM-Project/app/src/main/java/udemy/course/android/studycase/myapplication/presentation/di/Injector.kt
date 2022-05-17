package udemy.course.android.studycase.myapplication.presentation.di

import udemy.course.android.studycase.myapplication.presentation.di.artist.ArtistSubComponent
import udemy.course.android.studycase.myapplication.presentation.di.movie.MovieSubComponent
import udemy.course.android.studycase.myapplication.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
}