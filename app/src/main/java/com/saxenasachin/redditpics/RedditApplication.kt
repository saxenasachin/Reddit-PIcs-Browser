package com.saxenasachin.redditpics

import android.app.Application
import com.saxenasachin.redditpics.di.AppComponent
import com.saxenasachin.redditpics.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class RedditApplication : Application(), HasAndroidInjector {

    init {
        instance = this
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    var appComponent: AppComponent =
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .also {
                it.inject(this)
            }

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        var instance: RedditApplication? = null
        fun appComponent(): AppComponent {
            return instance!!.appComponent
        }
    }
}
