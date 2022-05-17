package udemy.course.android.studycase.myapplication.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import udemy.course.android.studycase.myapplication.data.database.dao.ArtistDao
import udemy.course.android.studycase.myapplication.data.database.dao.MovieDao
import udemy.course.android.studycase.myapplication.data.database.dao.TvShowDao
import udemy.course.android.studycase.myapplication.data.model.artist.Artist
import udemy.course.android.studycase.myapplication.data.model.movie.Movie
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow

@Database(entities = [Movie::class, Artist::class, TvShow::class],
    version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract fun tvShowDao(): TvShowDao

}