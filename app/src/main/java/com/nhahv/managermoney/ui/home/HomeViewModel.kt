package com.nhahv.managermoney.ui.home

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
        loadPosts()
    }

    private fun loadPosts() {
        /*subscription = postRepository.getRemotePosts()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .doOnSubscribe { }
            .doOnTerminate { }
            .subscribe({ result ->
                responseData.value = Gson().toJson(result)
                println("====================== success")
            }, { println("====================== Error") })
*/

//        postRepository.getLocalPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ result -> responseData.value = Gson().toJson(result) }, {})

    }
}
