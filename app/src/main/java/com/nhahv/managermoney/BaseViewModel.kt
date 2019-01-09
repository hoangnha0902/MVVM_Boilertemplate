package com.nhahv.managermoney

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    var subscription: Disposable? = null

    override fun onCleared() {
        super.onCleared()
        subscription?.dispose()
    }
}