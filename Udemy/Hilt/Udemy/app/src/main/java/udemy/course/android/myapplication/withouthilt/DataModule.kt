package udemy.course.android.myapplication.withouthilt

import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideDataSource(): DataSource {
        return DataSource()
    }
}