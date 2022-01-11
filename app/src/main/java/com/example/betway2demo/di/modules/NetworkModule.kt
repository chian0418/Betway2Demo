package com.example.betway2demo.di.modules

import com.example.betway2demo.BWayApplication
import dagger.Module
import dagger.Provides
import net.funpodium.funpodiumsdk.TraefikHelper
import net.funpodium.funpodiumsdk.TraefikProtocol
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun getBrandSDK(): TraefikProtocol {
        return TraefikHelper.getSDKInstance(
            BWayApplication.getInstance().applicationContext, "Betway.IM.App",
            TraefikHelper.Language.ZH_CN,
            TraefikHelper.Channel.DEV,
            "CNY"
        )
    }
}