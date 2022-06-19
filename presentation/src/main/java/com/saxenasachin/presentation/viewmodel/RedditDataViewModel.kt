package com.saxenasachin.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.saxenasachin.domain.interactor.piclist.GetPicsListUseCase
import com.saxenasachin.domain.models.piclist.RedditPicModel
import com.saxenasachin.presentation.base.BaseViewModel
import com.saxenasachin.presentation.views.mappers.piclist.SingleRedditPicViewMapper
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
    private val singleRedditPicViewMapper: SingleRedditPicViewMapper,
    private val getPicsListUseCase: GetPicsListUseCase
) : BaseViewModel<RedditDataState>() {

    private var state: RedditDataState = RedditDataState.Init
        set(value) {
            field = value
            publishState(value)
        }

    fun getRedditPics() {
        state = RedditDataState.Loading("Fetching Reddit Pics...")
        getPicsListUseCase
            .execute(object : DisposableSingleObserver<RedditPicModel>() {
                override fun onSuccess(t: RedditPicModel) {
                    state = RedditDataState.GetRedditPicsSuccess(
                        singleRedditPicViewMapper.mapToView(t)
                    )
                }

                override fun onError(e: Throwable) {
                    state = RedditDataState.Error(e.transform().localizedMessage)
                }
            }, null)
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