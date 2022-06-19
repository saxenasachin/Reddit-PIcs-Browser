package com.saxenasachin.redditpics.di.modules

import androidx.lifecycle.ViewModelProvider
import com.saxenasachin.redditpics.di.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
Created by Sachin Saxena on 19/06/22.
 */
@Module
abstract class ViewModelProviderModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
