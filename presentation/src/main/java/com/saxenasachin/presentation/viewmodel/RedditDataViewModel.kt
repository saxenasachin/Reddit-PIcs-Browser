package com.saxenasachin.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.saxenasachin.domain.interactor.pullrequests.GetPullRequestListUseCase
import com.saxenasachin.domain.interactor.user_repos.GetUserRepositoryListUseCase
import com.saxenasachin.domain.models.pullrequest.PullRequest
import com.saxenasachin.domain.models.repo.GitSingleRepo
import com.saxenasachin.presentation.base.BaseViewModel
import com.saxenasachin.presentation.views.mappers.git_repos.SingleGitRepoViewMapper
import com.saxenasachin.presentation.views.mappers.pull_requets.PullRequestViewMapper
import io.reactivex.observers.DisposableSingleObserver
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.net.ssl.SSLHandshakeException

/**
Created by Sachin Saxena on 19/06/22.
 */
class GitDataViewModel @Inject constructor(
    private val pullRequestViewMapper: PullRequestViewMapper,
    private val singleGitRepoViewMapper: SingleGitRepoViewMapper,
    private val getPullRequestListUseCase: GetPullRequestListUseCase,
    private val getUserRepositoryListUseCase: GetUserRepositoryListUseCase
) : BaseViewModel<RedditDataState>() {

    private var state: RedditDataState = RedditDataState.Init
        set(value) {
            field = value
            publishState(value)
        }

    fun getUserAllRepositories(userName: String) {
        state = RedditDataState.Loading("Fetching $userName's repositories")
        getUserRepositoryListUseCase
            .execute(object : DisposableSingleObserver<List<GitSingleRepo>>() {
                override fun onSuccess(t: List<GitSingleRepo>) {
                    state = RedditDataState.GetUsersRepositoriesSuccess(t.map {
                        singleGitRepoViewMapper.mapToView(it)
                    })
                }

                override fun onError(e: Throwable) {
                    state = RedditDataState.Error(e.transform().localizedMessage)
                }
            }, GetUserRepositoryListUseCase.Params(userName))
    }

    fun getPullRequestsForRepos(userName: String, repoName: String, prState: PullRequest.State) {
        state = RedditDataState.Loading("Fetching $repoName's pull requests")
        getPullRequestListUseCase.execute(object : DisposableSingleObserver<List<PullRequest>>() {
            override fun onSuccess(t: List<PullRequest>) {
                state = RedditDataState.GetPullRequestsSuccess(t.map {
                    pullRequestViewMapper.mapToView(it)
                })
            }

            override fun onError(e: Throwable) {
                state = RedditDataState.Error(e.transform().localizedMessage)
            }
        }, GetPullRequestListUseCase.Params(userName, repoName, prState))
    }

    fun resetState() {
        state = RedditDataState.Init
    }

    override val stateObservable: MutableLiveData<RedditDataState> by lazy {
        MutableLiveData<RedditDataState>()
    }
}

fun Throwable.transform(): Exception {
    return when (this) {
        is UnknownHostException,
        is InterruptedIOException,
        is ConnectException -> Exception("You 're currently offline. Please check your network connection and try again.")
        is SSLHandshakeException,
        is SocketTimeoutException -> Exception("We are unable to connect to our servers. Please check your connection and try again.")
        else -> Exception("Something went wrong please try again.")
    }
}