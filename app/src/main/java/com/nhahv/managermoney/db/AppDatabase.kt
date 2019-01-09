package com.nhahv.managermoney.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nhahv.managermoney.data.model.Post

@Database(entities = [Post::class], version = AppDatabase.DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        const val DATABASE_VERSION = 1
    }
}