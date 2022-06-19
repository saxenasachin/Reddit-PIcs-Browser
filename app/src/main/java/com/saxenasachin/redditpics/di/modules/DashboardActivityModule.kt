package com.saxenasachin.redditpics.di.modules

import androidx.lifecycle.ViewModel
import com.saxenasachin.redditpics.di.scope.ViewModelKey
import com.saxenasachin.presentation.viewmodel.GitDataViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
Created by Sachin Saxena on 19/06/22.
 */
@Module
abstract class DashboardActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(GitDataViewModel::class)
    abstract fun bindsMainViewModel(gitDataViewModel: GitDataViewModel): ViewModel
}