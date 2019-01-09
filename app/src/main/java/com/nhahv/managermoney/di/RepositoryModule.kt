package com.nhahv.managermoney.di

import com.nhahv.managermoney.data.repository.PostLocalDataSource
import com.nhahv.managermoney.data.repository.PostRemoteDataSource
import com.nhahv.managermoney.data.repository.PostRepository
import com.nhahv.managermoney.data.repository.PostRepositoryImpl
import com.nhahv.managermoney.db.PostDao
import com.nhahv.managermoney.network.PostAPI
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providePostLocalRepository(postDao: PostDao) = PostLocalDataSource(postDao)

    @Provides
    fun providePostRemoteRepository(postAPI: PostAPI) = PostRemoteDataSource(postAPI)

    @Provides
    fun providePostRepository(postLocal: PostLocalDataSource, postRemote: PostRemoteDataSource): PostRepository {
        return PostRepositoryImpl.getInstance(postLocal, postRemote)
    }
}