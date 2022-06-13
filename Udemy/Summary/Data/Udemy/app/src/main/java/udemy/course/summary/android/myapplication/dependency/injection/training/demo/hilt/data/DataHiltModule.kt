package udemy.course.summary.android.myapplication.dependency.injection.training.demo.hilt.data

import dagger.Module
import dagger.Provides

@Module
class DataHiltModule {
    @Provides
    fun provideDataSource(): DataSource {
        return DataSource()
    }
}