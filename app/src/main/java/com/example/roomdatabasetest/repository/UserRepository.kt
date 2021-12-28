package com.example.roomdatabasetest.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabasetest.data.UserDao
import com.example.roomdatabasetest.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updareUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUSers() {
        userDao.deleteAllUsers()
    }

    suspend fun resertCounter() {
        userDao.resertCounter()
    }
}