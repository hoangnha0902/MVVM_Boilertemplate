package com.nhahv.managermoney.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nhahv.managermoney.data.model.Post
import io.reactivex.Observable

@Dao
interface PostDao {
    @Query("SELECT * FROM post")
    fun getPosts(): Observable<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(posts: List<Post>)
}