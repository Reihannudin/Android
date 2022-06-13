package udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.core.module.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.api.service.TMDBService
import javax.inject.Singleton

@Module
class NetworkModule(private val baseUrl :String) {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit :Retrofit):TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}