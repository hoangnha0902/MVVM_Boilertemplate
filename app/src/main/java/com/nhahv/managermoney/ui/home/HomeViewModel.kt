package com.nhahv.managermoney.ui.home

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.nhahv.managermoney.BaseViewModel
import com.nhahv.managermoney.data.model.UserWedding
import com.nhahv.managermoney.data.repository.PostRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : BaseViewModel() {

    val responseData: MutableLiveData<String> = MutableLiveData()
    val userWeds = MutableLiveData<List<UserWedding>>()

    init {
        loadDatas()
    }

    @SuppressLint("CheckResult")
    private fun loadDatas() {
        subscription = postRepository.getRemotePosts()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .doOnSubscribe { }
            .doOnTerminate { }
            .subscribe({ result ->
                println("===================== success")
                postRepository.insertPosts(result)
            }, { println("====================== Error") })


        postRepository.getLocalPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result -> responseData.value = Gson().toJson(result) }, {})
    }
}
