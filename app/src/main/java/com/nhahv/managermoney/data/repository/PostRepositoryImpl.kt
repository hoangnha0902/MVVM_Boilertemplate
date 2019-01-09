package com.nhahv.managermoney.data.repository

import com.nhahv.managermoney.data.model.Post
import io.reactivex.Flowable


class PostRepositoryImpl(
        private val postLocalDataSource: PostLocalDataSource,
        private val postRemoteDataSource: PostRemoteDataSource
) : PostRepository {

    override fun getLocalPosts(): Flowable<List<Post>> {
        return postLocalDataSource.getPostList()
    }

    override fun getRemotePosts(): Flowable<List<Post>> {
        return postRemoteDataSource.getPostList()
    }

    override fun insertPosts(posts: List<Post>) {
        postLocalDataSource.insertPosts(posts)
    }

    override fun insertPost(post: Post) {
        postLocalDataSource.insertPost(post)
    }

    companion object {
        private var INSTANCE: PostRepositoryImpl? = null

        @JvmStatic
        fun getInstance(
                postLocalDataSource: PostLocalDataSource,
                postRemoteDataSource: PostRemoteDataSource
        ) = INSTANCE ?: synchronized(PostRepositoryImpl::class.java) {
            INSTANCE ?: PostRepositoryImpl(
                    postLocalDataSource,
                    postRemoteDataSource
            ).also { INSTANCE = it }
        }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
