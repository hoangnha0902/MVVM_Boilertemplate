package com.nhahv.managermoney.ui.profile

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.nhahv.managermoney.BaseViewModel
import com.nhahv.managermoney.data.repository.PostRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@SuppressLint("CheckResult")
class ProfileViewModel @Inject constructor(postRepository: PostRepository) : BaseViewModel() {
    val responseData: MutableLiveData<String> = MutableLiveData()

    init {

        subscription = postRepository.getRemotePosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { }
                .doOnTerminate { }
                .subscribe({ result ->
                    responseData.value = Gson().toJson(result)
                }, { error -> println("====================== Error $error") })

/*

        postRepository.getLocalPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result -> responseData.value = Gson().toJson(result) }, {})
*/

    }
}
