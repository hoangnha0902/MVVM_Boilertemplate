package com.nhahv.managermoney.di

import com.nhahv.managermoney.network.PostAPI
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    val BASE_URL: String = "https://jsonplaceholder.typicode.com"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
            ).build()
    }

    @Singleton
    @Provides
    fun providePostAPI(retrofit: Retrofit) = retrofit.create(PostAPI::class.java)
}