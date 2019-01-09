package com.nhahv.managermoney.data.repository

import com.nhahv.managermoney.data.model.Post
import com.nhahv.managermoney.db.PostDao
import com.nhahv.managermoney.network.PostAPI
import io.reactivex.Flowable

class PostRemoteDataSource(private val postAPI: PostAPI) {

    fun getPostList(): Flowable<List<Post>> {
        return postAPI.getPosts()
    }
}

class PostLocalDataSource(private val postDao: PostDao) {

    fun getPostList(): Flowable<List<Post>> {
        return postDao.getPosts()
    }

    fun insertPosts(posts: List<Post>) {
        postDao.insertPosts(posts)
    }

    fun insertPost(post: Post) {
        postDao.insertPost(post)
    }
}