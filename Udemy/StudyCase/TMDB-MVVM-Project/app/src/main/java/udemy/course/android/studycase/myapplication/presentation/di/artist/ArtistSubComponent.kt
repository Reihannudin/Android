package udemy.course.android.studycase.myapplication.presentation.di.artist

import dagger.Subcomponent
import udemy.course.android.studycase.myapplication.presentation.artist.ArtistActivity
import udemy.course.android.studycase.myapplication.presentation.di.movie.MovieSubComponent
import udemy.course.android.studycase.myapplication.presentation.movie.MovieActivity

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}