package com.nhahv.managermoney.data.repository

import com.nhahv.managermoney.data.model.Post
import io.reactivex.Observable

interface PostRepository {
    fun getLocalPosts(): Observable<List<Post>>
    fun getRemotePosts(): Observable<List<Post>>
    fun insertPosts(posts: List<Post>)
    fun insertPost(post: Post)
}