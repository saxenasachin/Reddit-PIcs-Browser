package com.saxenasachin.redditpics.di.modules

import com.saxenasachin.redditpics.ui.DashboardActivity
import com.doubtnut.core.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
Created by Sachin Saxena on 19/06/22.
 */
@Module
abstract class BindingActivityModule {

    @ContributesAndroidInjector(modules = [DashboardActivityModule::class])
    @PerActivity
    abstract fun contributeDashboardActivityInjector(): DashboardActivity
}