package com.example.betway2demo.di

import android.content.Context
import com.example.betway2demo.BWayApplication
import com.example.betway2demo.di.modules.ActivityBuilderModule
import com.example.betway2demo.di.modules.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<BWayApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}