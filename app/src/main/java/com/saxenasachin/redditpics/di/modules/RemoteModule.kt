package com.saxenasachin.redditpics.di.modules

import com.saxenasachin.data.repositories.RedditRemote
import com.saxenasachin.redditpics.BuildConfig
import com.saxenasachin.remote.RedditRemoteRepositoryImp
import com.saxenasachin.remote.services.RedditServiceFactory
import com.saxenasachin.remote.services.github.RedditService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Created by Sachin Saxena on 19/06/22.
 */
@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideGitRemote(gitRemoteImp: RedditRemoteRepositoryImp): RedditRemote {
        return gitRemoteImp
    }

    @Provides
    @Singleton
    fun provideGitService(): RedditService {
        return RedditServiceFactory.create(
            BuildConfig.DEBUG,
            BuildConfig.BASE_URL
        )
    }
}
