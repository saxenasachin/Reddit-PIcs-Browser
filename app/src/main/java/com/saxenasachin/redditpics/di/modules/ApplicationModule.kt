package com.saxenasachin.redditpics.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
Created by Sachin Saxena on 19/06/22.
 */
@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context
}
