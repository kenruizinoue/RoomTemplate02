package com.kenruizinoue.roomtemplate02.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int? = null,
    val firstName: String,
    val lastName: String,
    val age: Int
)