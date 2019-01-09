package com.nhahv.managermoney.data.repository

import com.nhahv.managermoney.data.model.Post
import io.reactivex.Flowable

interface PostRepository {
    fun getLocalPosts(): Flowable<List<Post>>
    fun getRemotePosts(): Flowable<List<Post>>
    fun insertPosts(posts: List<Post>)
    fun insertPost(post: Post)
}