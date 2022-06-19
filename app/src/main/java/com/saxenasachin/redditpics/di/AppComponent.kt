package com.saxenasachin.redditpics.di

import android.app.Application
import com.saxenasachin.redditpics.RedditApplication
import com.saxenasachin.redditpics.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
Created by Sachin Saxena on 19/06/22.
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        BindingActivityModule::class,
        DashboardActivityModule::class,
        ViewModelProviderModule::class,
        DomainModule::class,
        RemoteModule::class,
        UIModule::class,
        AndroidSupportInjectionModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(redditApplication: RedditApplication)
}