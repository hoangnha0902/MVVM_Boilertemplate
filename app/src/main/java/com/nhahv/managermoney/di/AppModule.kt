package com.nhahv.managermoney.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.nhahv.managermoney.db.AppDatabase
import com.nhahv.managermoney.utils.UserWedCallback
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    val DATABASE_NAME = "money_manager_db"
    val SHARE_PREF_NAME = "share_pref"

    @Singleton
    @Provides
    fun provideAppDatabase(app: Application) = Room.databaseBuilder(app, AppDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providePostDao(db: AppDatabase) = db.postDao()

    @Singleton
    @Provides
    fun provideSharePref(app: Application): SharedPreferences {
        return app.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    fun provideUserWedCallback(): UserWedCallback = UserWedCallback()
}