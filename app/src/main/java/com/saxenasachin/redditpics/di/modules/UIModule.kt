package com.saxenasachin.redditpics.di.modules

import com.saxenasachin.domain.executor.PostExecutionThread
import com.saxenasachin.redditpics.UiThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Created by Sachin Saxena on 19/06/22.
 */
@Module
class UIModule {

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }
}
