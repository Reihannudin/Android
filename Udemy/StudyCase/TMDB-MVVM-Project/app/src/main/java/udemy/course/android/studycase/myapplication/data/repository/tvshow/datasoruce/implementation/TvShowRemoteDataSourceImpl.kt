package udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.implementation

import retrofit2.Response
import udemy.course.android.studycase.myapplication.data.api.TMDBService
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShowList
import udemy.course.android.studycase.myapplication.data.repository.tvshow.datasoruce.TvShowRemoteDataSource

class TvShowRemoteDataSourceImpl (
    private val tmdbService: TMDBService,
    private val apiKey:String
    ) : TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowList> {
        return tmdbService.getPopularTvShow(apiKey)
    }
}
