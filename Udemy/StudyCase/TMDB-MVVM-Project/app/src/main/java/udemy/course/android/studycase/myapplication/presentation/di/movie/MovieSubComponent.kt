package udemy.course.android.studycase.myapplication.presentation.di.movie

import dagger.Subcomponent
import udemy.course.android.studycase.myapplication.presentation.movie.MovieActivity

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}