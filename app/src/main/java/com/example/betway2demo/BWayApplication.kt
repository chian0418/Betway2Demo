package com.example.betway2demo

import android.app.Application
import com.example.betway2demo.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BWayApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    companion object {
        lateinit var instance: Application
            private set

        fun getInstance(): BWayApplication {
            return instance as BWayApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        DaggerApplicationComponent.factory().create(this).inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }


}