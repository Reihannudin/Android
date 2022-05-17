package udemy.course.android.studycase.myapplication.presentation.di.core.component

import dagger.Component
import udemy.course.android.studycase.myapplication.presentation.di.artist.ArtistSubComponent
import udemy.course.android.studycase.myapplication.presentation.di.core.module.*
import udemy.course.android.studycase.myapplication.presentation.di.movie.MovieSubComponent
import udemy.course.android.studycase.myapplication.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class, DatabaseModule::class,
    LocalDataSourceModule::class, RemoteDataSourceModule::class,
    CacheDataSourceModule::class, RepositoryModule::class, UseCaseModule::class
])
interface AppCompnent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
}