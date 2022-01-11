package com.example.betway2demo.di.modules

import com.example.betway2demo.repo.MainRepo
import dagger.Module
import dagger.Provides
import net.funpodium.funpodiumsdk.TraefikProtocol
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class
    ]
)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepo(
        brandSDk: TraefikProtocol
    ): MainRepo {
        return MainRepo(brandSDk)
    }
}