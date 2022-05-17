package udemy.course.android.studycase.myapplication.presentation.di.core.module

import android.content.Context
import dagger.Module
import dagger.Provides
import udemy.course.android.studycase.myapplication.presentation.di.artist.ArtistSubComponent
import udemy.course.android.studycase.myapplication.presentation.di.movie.MovieSubComponent
import udemy.course.android.studycase.myapplication.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, ArtistSubComponent::class, TvShowSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun providerApplicationContext(): Context {
        return context.applicationContext
    }
}