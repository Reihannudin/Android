package udemy.course.android.myapplication.viewmodels.repository

import kotlinx.coroutines.delay
import udemy.course.android.myapplication.viewmodels.model.UserModel

class UserRepository {

    suspend fun getUsers(): List<UserModel>{
        delay(8000)
        val users : List<UserModel> = listOf(
            UserModel(1, "John"),
            UserModel(2, "Jane"),
            UserModel(3, "Jack"),
            UserModel(4, "Jill")
        )
        return users
    }
}