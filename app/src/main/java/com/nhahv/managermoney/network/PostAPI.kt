package com.nhahv.managermoney.network

import com.nhahv.managermoney.data.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostAPI {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}