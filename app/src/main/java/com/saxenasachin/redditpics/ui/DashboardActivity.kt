package com.saxenasachin.redditpics.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.saxenasachin.presentation.base.BaseViewModel
import com.saxenasachin.presentation.viewmodel.GitDataViewModel
import com.saxenasachin.presentation.viewmodel.RedditDataState
import com.saxenasachin.redditpics.R
import com.saxenasachin.redditpics.databinding.ActivityDashboardBinding
import com.saxenasachin.redditpics.di.ViewModelFactory
import com.saxenasachin.redditpics.extensions.addFragment
import com.saxenasachin.redditpics.extensions.gone
import com.saxenasachin.redditpics.extensions.viewModelProvider
import com.saxenasachin.redditpics.extensions.visible
import com.saxenasachin.redditpics.ui.base.BaseBindingActivity
import com.saxenasachin.redditpics.ui.imagelist.RedditPicsFragment
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class DashboardActivity :
    BaseBindingActivity<BaseViewModel<RedditDataState>, ActivityDashboardBinding>() {

    companion object {
        private const val TAG = "DashboardActivity"
        fun getStartIntent(context: Context): Intent =
            Intent(context, DashboardActivity::class.java)
    }

    @Inject
    lateinit var viewModeFactory: ViewModelFactory

    override fun setupObservers() {
        super.setupObservers()
        viewModel.stateObservable.observe(this, Observer {
            updateState(it)
        })
    }

    private fun updateState(state: RedditDataState) {
        when (state) {
            is RedditDataState.Loading -> showLoading(state.message)
            else -> hideLoading()
        }
    }

    private fun showLoading(message: String) {
        binding.apply {
            tvLoadingMessage.text = message
            tvLoadingMessage.visible()
            loadingProgressbar.visible()
            mainFragmentContainer.gone()
        }
    }

    private fun hideLoading() {
        binding.apply {
            tvLoadingMessage.gone()
            loadingProgressbar.gone()
            mainFragmentContainer.visible()
        }
    }

    private fun loadLandingFragment() {
        addFragment(R.id.mainFragmentContainer, RedditPicsFragment.newInstance(""))
    }

    override fun provideViewBinding(): ActivityDashboardBinding =
        ActivityDashboardBinding.inflate(layoutInflater)

    override fun providePageName(): String = TAG

    override fun provideViewModel(): BaseViewModel<RedditDataState> =
        viewModelProvider<GitDataViewModel>(viewModeFactory)

    override fun setupView(savedInstanceState: Bundle?) {
        loadLandingFragment()
    }
}