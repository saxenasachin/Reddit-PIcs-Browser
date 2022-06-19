package com.saxenasachin.redditpics.di.modules

import com.doubtnut.core.di.scope.PerFragment
import com.saxenasachin.redditpics.ui.imagelist.RedditPicsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
Created by Sachin Saxena on 19/06/22.
 */
@Module
abstract class BindingFragmentModule {

    @ContributesAndroidInjector
    @PerFragment
    internal abstract fun contributeRedditPicsFragment(): RedditPicsFragment
}