package com.saxenasachin.redditpics.ui.imagelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.saxenasachin.presentation.viewmodel.GitDataViewModel
import com.saxenasachin.presentation.viewmodel.RedditDataState
import com.saxenasachin.presentation.views.views.SingleRepoView
import com.saxenasachin.redditpics.R
import com.saxenasachin.redditpics.databinding.FragmentRedditPicsBinding
import com.saxenasachin.redditpics.extensions.toast
import com.saxenasachin.redditpics.ui.base.BaseBindingFragment
import com.saxenasachin.redditpics.ui.user_repositories.adaptor.UserRepositoriesAdaptor

/**
Created by Sachin Saxena on 19/06/22.
 */
class RedditPicsFragment : BaseBindingFragment<GitDataViewModel, FragmentRedditPicsBinding>(),
    UserRepositoriesAdaptor.OnItemCLickListener {

    private val userName: String? by lazy {
        arguments?.getString(ARGS_USERNAME)
    }

    companion object {
        const val TAG = "RedditPicsFragment"
        private const val ARGS_USERNAME = "args_username"
        fun newInstance(userName: String): RedditPicsFragment {
            val bundle = Bundle()
            bundle.putString(ARGS_USERNAME, userName)
            val fragment = RedditPicsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRedditPicsBinding =
        FragmentRedditPicsBinding.inflate(layoutInflater, container, false)

    override fun providePageName(): String = TAG

    override fun provideViewModel(): GitDataViewModel =
        ViewModelProviders.of(requireActivity()).get(GitDataViewModel::class.java)

    override fun setupView(view: View, savedInstanceState: Bundle?) {
        fetchRepositories()
    }

    private fun fetchRepositories() {
        viewModel.getRedditPics()
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.stateObservable.observe(this, Observer {
            updateState(it)
        })
    }

    private fun updateState(state: RedditDataState) {
        when (state) {
            is RedditDataState.GetUsersRepositoriesSuccess -> showRepoList(state.lisOfRepos)
            is RedditDataState.Error -> {
                popUpFragment(state.message)
            }
            else -> {}
        }
    }

    private fun showRepoList(lisOfRepos: List<SingleRepoView>) {
        if (lisOfRepos.isNotEmpty()) {
            binding.userRepoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.userRepoRecyclerView.adapter = UserRepositoriesAdaptor(lisOfRepos, this)
        } else {
            popUpFragment(getString(R.string.info_no_repositories))
        }
    }

    override fun onRepoClick(repoView: SingleRepoView) {
//        addFragmentBackStack(
//            R.id.mainFragmentContainer,
//            PullRequestsFragment.newInstance(userName.orEmpty(), repoView.repoName),
//            PullRequestsFragment.TAG
//        )
    }

    private fun popUpFragment(message: String) {
        viewModel.resetState()
        toast(message)
        fragmentManager?.popBackStack()
    }
}