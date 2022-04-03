package com.example.android.devbyteviewer.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.android.devbyteviewer.database.getDatabase
import com.example.android.devbyteviewer.repository.VideosRepository
import retrofit2.HttpException
import timber.log.Timber

//Make Worker
// extend CoroutineWorker and add context and WorkerParameters as constructor
class RefreshDataWorker(appContext: Context, params: WorkerParameters):
    CoroutineWorker (appContext , params){

//    define Name Worker for identification worker
    companion object{
        const val WORK_NAME = "com.example.android.devbyteviewer.work.RefreshDataWorker"
    }


//    implement the doWork function
    override suspend fun doWork(): Result {
//    make instance of VideoDatabase and VideosRepository object
        val database = getDatabase(applicationContext)
        val repository = VideosRepository(database)
//      make try and catch block
        try {
//            call the refresh function of repository
            repository.refreshVideos()
//            use Timber
            Timber.d("Work request for sync is run")
        } catch (e: HttpException) {
//            use Timber
            Timber.e(e, "Retry, error during sync")
//            return Result.retry()
            return Result.failure()
        }
//        return Result to indicate success
        return Result.success()
    }


}