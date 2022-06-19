package com.saxenasachin.redditpics.di.modules

import com.saxenasachin.data.RedditDataRepository
import com.saxenasachin.data.executor.JobExecutor
import com.saxenasachin.domain.RedditRepository
import com.saxenasachin.domain.executor.ThreadExecutor
import com.saxenasachin.domain.interactor.core.SingleUseCase
import com.saxenasachin.domain.interactor.piclist.GetPicsListUseCase
import com.saxenasachin.domain.interactor.pullrequests.GetPullRequestListUseCase
import com.saxenasachin.domain.interactor.user_repos.GetUserRepositoryListUseCase
import com.saxenasachin.domain.models.piclist.RedditPicModel
import com.saxenasachin.domain.models.pullrequest.PullRequest
import com.saxenasachin.domain.models.repo.GitSingleRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Created by Sachin Saxena on 19/06/22.
 */
@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideGitRepository(redditDataRepository: RedditDataRepository): RedditRepository {
        return redditDataRepository
    }

    @Provides
    @Singleton
    fun provideGetUserRepositoriesUseCase(
        getUserRepositoryListUseCase: GetUserRepositoryListUseCase
    ): SingleUseCase<GetUserRepositoryListUseCase.Params, List<GitSingleRepo>> {
        return getUserRepositoryListUseCase
    }

    @Provides
    @Singleton
    fun provideGetPullRequestListUseCase(
        getPullRequestListUseCase: GetPullRequestListUseCase
    ): SingleUseCase<GetPullRequestListUseCase.Params, List<PullRequest>> {
        return getPullRequestListUseCase
    }

    @Provides
    @Singleton
    fun provideRedditPicsRequestListUseCase(
        getRedditUseCase: GetPicsListUseCase
    ): SingleUseCase<GetPicsListUseCase.Params, RedditPicModel> {
        return getRedditUseCase
    }

    @Provides
    @Singleton
    fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }
}
