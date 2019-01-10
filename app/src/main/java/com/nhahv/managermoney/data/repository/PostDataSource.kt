package com.nhahv.managermoney.data.repository

import com.nhahv.managermoney.data.model.Post
import com.nhahv.managermoney.db.PostDao
import com.nhahv.managermoney.network.PostAPI
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class PostRemoteDataSource(private val postAPI: PostAPI, private val postDao: PostDao) {

    fun getPostList(): Observable<List<Post>> {
        return postAPI.getPosts()
                .subscribeOn(Schedulers.io())
                .flatMap { posts ->
                    println("===================== $posts")
                    postDao.insertPosts(posts)
                    Observable.defer { Observable.just(posts) }
                }
    }
}

class PostLocalDataSource(private val postDao: PostDao) {

    fun getPostList(): Observable<List<Post>> {
        return postDao.getPosts()
    }

    fun insertPosts(posts: List<Post>) {
        postDao.insertPosts(posts)
    }

    fun insertPost(post: Post) {
        postDao.insertPost(post)
    }
}