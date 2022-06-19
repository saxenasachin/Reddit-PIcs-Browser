package com.saxenasachin.redditpics.ui.user_repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.saxenasachin.redditpics.extensions.addFragmentBackStack
import com.saxenasachin.redditpics.extensions.toast
import com.saxenasachin.redditpics.ui.pull_requests.PullRequestsFragment
import com.saxenasachin.redditpics.ui.user_repositories.adaptor.UserRepositoriesAdaptor
import com.saxenasachin.presentation.viewmodel.GitDataViewModel
import com.saxenasachin.presentation.viewmodel.RedditDataState
import com.saxenasachin.presentation.views.views.SingleRepoView
import com.saxenasachin.redditpics.R
import kotlinx.android.synthetic.main.fragment_user_repositories.view.*

/**
Created by Sachin Saxena on 19/06/22.
 */
class UserRepositoriesFragment : Fragment(), UserRepositoriesAdaptor.OnItemCLickListener {

    private lateinit var mView: View

    private lateinit var userName: String

    private lateinit var gitDataViewModel: GitDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getString(ARGS_USERNAME)?.let {
            userName = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_user_repositories, container, false)
        init()
        setObservers()
        fetchRepositories()
        return mView.rootView
    }

    private fun fetchRepositories() {
        gitDataViewModel.getUserAllRepositories(userName)
    }

    private fun setObservers() {
        gitDataViewModel.stateObservable.observe(this, Observer {
            updateState(it)
        })
    }

    private fun init() {
        gitDataViewModel =
            ViewModelProviders.of(requireActivity()).get(GitDataViewModel::class.java)
    }


    private fun updateState(state: RedditDataState) {
        when (state) {
            is RedditDataState.GetUsersRepositoriesSuccess -> showRepoList(state.lisOfRepos)
            is RedditDataState.Error -> {
                popUpFragment(state.message)
            }
        }
    }

    private fun showRepoList(lisOfRepos: List<SingleRepoView>) {
        if (lisOfRepos.isNotEmpty()) {
            mView.userRepoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            mView.userRepoRecyclerView.adapter = UserRepositoriesAdaptor(lisOfRepos, this)
        } else {
            popUpFragment(getString(R.string.info_no_repositories))
        }
    }

    override fun onRepoClick(repoView: SingleRepoView) {
        addFragmentBackStack(
            R.id.mainFragmentContainer,
            PullRequestsFragment.newInstance(userName, repoView.repoName),
            PullRequestsFragment.TAG
        )
    }

    private fun popUpFragment(message: String) {
        gitDataViewModel.resetState()
        toast(message)
        fragmentManager?.popBackStack()
    }

    companion object {
        const val TAG = "UserRepositoriesFragment"
        private const val ARGS_USERNAME = "args_username"
        fun newInstance(userName: String): UserRepositoriesFragment {
            val bundle = Bundle()
            bundle.putString(ARGS_USERNAME, userName)
            val fragment = UserRepositoriesFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}