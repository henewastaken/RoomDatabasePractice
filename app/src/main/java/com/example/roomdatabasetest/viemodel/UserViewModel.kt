package com.example.roomdatabasetest.viemodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabasetest.data.UserDatabase
import com.example.roomdatabasetest.repository.UserRepository
import com.example.roomdatabasetest.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application). userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updareUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUSers()
        }
    }

    fun resertCounter() {
        viewModelScope.launch (Dispatchers.IO){
            repository.resertCounter()
        }
    }
}