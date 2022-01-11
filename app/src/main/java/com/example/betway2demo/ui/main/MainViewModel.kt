package com.example.betway2demo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.betway2demo.repo.MainRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepo: MainRepo
) : ViewModel() {
    val webViewUrl: LiveData<String>
        get() = _webViewUrl
    private var _webViewUrl = MutableLiveData<String>()
    private var apiDisposable: CompositeDisposable = CompositeDisposable()

    fun getWebUrl() {
        apiDisposable.add(
            mainRepo.getWebViewUrl(MainViewModel::class.java.simpleName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    _webViewUrl.postValue(it.webviewUrl)
                }, {
                    it.printStackTrace()
                })
        )
    }

}