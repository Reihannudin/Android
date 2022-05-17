package udemy.course.android.studycase.myapplication.presentation

import android.app.Application
import udemy.course.android.studycase.myapplication.BuildConfig
import udemy.course.android.studycase.myapplication.presentation.di.Injector
import udemy.course.android.studycase.myapplication.presentation.di.artist.ArtistSubComponent
import udemy.course.android.studycase.myapplication.presentation.di.core.component.AppCompnent
import udemy.course.android.studycase.myapplication.presentation.di.core.component.DaggerAppCompnent
import udemy.course.android.studycase.myapplication.presentation.di.core.module.AppModule
import udemy.course.android.studycase.myapplication.presentation.di.core.module.NetModule
import udemy.course.android.studycase.myapplication.presentation.di.core.module.RemoteDataSourceModule
import udemy.course.android.studycase.myapplication.presentation.di.movie.MovieSubComponent
import udemy.course.android.studycase.myapplication.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppCompnent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppCompnent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL_API))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}