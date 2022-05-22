package udemy.course.android.myapplication.withhilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import udemy.course.android.myapplication.withouthilt.DataSource

@Module
//add instalin if use hilt
@InstallIn(SingletonComponent::class)
class HiltDataModule {
    @Provides
    fun provideHiltDataSource(): HiltDataSource {
        return HiltDataSource()
    }
}