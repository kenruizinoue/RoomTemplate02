package com.kenruizinoue.roomtemplate02.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kenruizinoue.roomtemplate02.R
import com.kenruizinoue.roomtemplate02.database.AppDatabase
import com.kenruizinoue.roomtemplate02.database.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.insertUser(User(firstName = "Ken", lastName = "Ruiz Inoue", age = 28))
        mainViewModel.getUsers().observe(this, Observer<List<User>> { users ->
            sizeTextView.text = users.size.toString()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        AppDatabase.destroyDataBase()
    }
}