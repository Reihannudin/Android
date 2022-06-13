package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.popular.artist

import dagger.Subcomponent
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.popular.artist.ArtistPopularTMDBFragment

@ArtistPopularScope
@Subcomponent(modules = [ArtistPopularModule::class])
interface ArtistPopularSubComponent {
    fun inject(artistPopularTMDBFragment: ArtistPopularTMDBFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistPopularSubComponent
    }

}