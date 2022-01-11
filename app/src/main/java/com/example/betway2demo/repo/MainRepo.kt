package com.example.betway2demo.repo

import io.reactivex.Observable
import net.funpodium.funpodiumsdk.TraefikProtocol
import net.funpodium.funpodiumsdk.model.requestdata.RequestData
import net.funpodium.funpodiumsdk.model.responsedata.WebviewUrlResponseData
import javax.inject.Inject

class MainRepo @Inject constructor(
    private val brandSdk: TraefikProtocol
) {
    fun getWebViewUrl(pageName: String): Observable<WebviewUrlResponseData> {
        return Observable.create {
            brandSdk.getWebviewUrl(RequestData(pageName)) { success, responseData, error ->
                if (!it.isDisposed) {
                    if (error != null) {
                        it.onError(error)
                    } else {
                        it.onNext(responseData.result as WebviewUrlResponseData)
                        it.onComplete()
                    }
                }
            }
        }
    }
}