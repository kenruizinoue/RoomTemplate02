package com.kenruizinoue.roomtemplate02.database

import androidx.lifecycle.LiveData

class DataRepository(private val userDao: UserDao) {

    fun getUsers(): LiveData<List<User>> {
        return userDao.getUsers()
    }

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}