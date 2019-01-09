package com.nhahv.managermoney.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.nhahv.managermoney.data.model.Post
import io.reactivex.Flowable

@Dao
interface PostDao {
    @Query("SELECT * FROM post")
    fun getPosts(): Flowable<List<Post>>

    @Insert(onConflict = REPLACE)
    fun insertPost(post: Post)

    @Insert
    fun insertPosts(posts: List<Post>)
}