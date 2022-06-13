package udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.onair.MovieOnAirDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.onair.TvShowOnAirDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.ArtistPopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.MoviePopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.popular.TvShowPopularDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.database.dao.trending.TrendingDao
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.PopularArtistKnowForTypeConverter
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.Trending
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.util.ConvertersString


@Database(entities = [MoviePopular::class, TvShowPopular::class, ArtistPopular::class,
    MovieOnAir::class, TvShowOnAir::class , Trending::class] ,
    version = 1, exportSchema = false)
@TypeConverters(ConvertersString::class, PopularArtistKnowForTypeConverter::class)

abstract class TMDBDatabase : RoomDatabase() {

    abstract fun moviePopularDao(): MoviePopularDao
    abstract fun tvShowPopularDao(): TvShowPopularDao
    abstract fun artistPopularDao(): ArtistPopularDao
    abstract fun movieOnAirDao(): MovieOnAirDao
    abstract fun tvShowOnAirDao(): TvShowOnAirDao
    abstract fun trendingDao(): TrendingDao
}