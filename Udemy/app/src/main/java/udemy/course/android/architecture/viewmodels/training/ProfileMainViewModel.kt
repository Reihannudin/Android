package udemy.course.android.architecture.viewmodels.training

import androidx.lifecycle.ViewModel

class ProfileMainViewModel : ViewModel() {

    private var username = ""

    fun getUsername(): String {
        return username
    }

    fun editUsername(newUsername: String) {
        username = newUsername
    }

    fun clearUsername() {
        username = ""
    }
}