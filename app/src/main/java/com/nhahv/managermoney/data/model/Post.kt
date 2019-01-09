package com.nhahv.managermoney.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class Post(val userId: Int, @PrimaryKey val id: Int, val title: String, val body: String)