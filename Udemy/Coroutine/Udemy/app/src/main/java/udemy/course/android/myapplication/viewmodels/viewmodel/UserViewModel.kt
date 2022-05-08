package udemy.course.android.myapplication.viewmodels.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import udemy.course.android.myapplication.viewmodels.model.UserModel
import udemy.course.android.myapplication.viewmodels.repository.UserRepository

class UserViewModel: ViewModel() {

    private val userRepository = UserRepository()

//  new livedata way
    val users = liveData(Dispatchers.IO) {
        val result = userRepository.getUsers()
        emit(result)
    }

//    old liveData way
//    val users : MutableLiveData<List<UserModel>> = MutableLiveData()
//
//    fun getUserData(){
//        viewModelScope.launch {
//            var result : List<UserModel>? = null
//            withContext(IO){
//                result = userRepository.getUsers()
//            }
//            users.value = result
//        }
//    }
}