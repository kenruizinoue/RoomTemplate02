package com.kenruizinoue.roomtemplate02.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kenruizinoue.roomtemplate02.database.AppDatabase
import com.kenruizinoue.roomtemplate02.database.DataRepository
import com.kenruizinoue.roomtemplate02.database.User
import kotlinx.coroutines.launch

// use AndroidViewModel so MainViewModel can use application to get the DB
class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DataRepository

    init {
        val userDao = AppDatabase
            .getDB(application)
            .userDao()
        repository = DataRepository(userDao)
    }

    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }

    fun getUsers(): LiveData<List<User>> {
        return repository.getUsers()
    }
}