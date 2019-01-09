package com.nhahv.managermoney.network

import com.nhahv.managermoney.data.model.Post
import io.reactivex.Flowable
import retrofit2.http.GET

interface PostAPI {

    @GET("/posts")
    fun getPosts(): Flowable<List<Post>>
}