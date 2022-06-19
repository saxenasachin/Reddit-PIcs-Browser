package com.saxenasachin.redditpics.ui.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saxenasachin.redditpics.extensions.addFragmentBackStack
import com.saxenasachin.redditpics.extensions.isValid
import com.saxenasachin.redditpics.extensions.toast
import com.saxenasachin.redditpics.ui.user_repositories.UserRepositoriesFragment
import com.saxenasachin.redditpics.R
import kotlinx.android.synthetic.main.fragment_landing.view.*

/**
Created by Sachin Saxena on 19/06/22.
 */
class LandingFragment : Fragment() {

    private lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_landing, container, false)
        onClicks()
        return mView.rootView
    }

    private fun onClicks() {
        mView.btnContinue.setOnClickListener {
            val userName = mView.edtUserName.editableText.toString()
            if (userName.isValid()) {
                goToNextFragment(userName)
            } else {
                toast(getString(R.string.info_valid_username))
            }
        }
    }

    private fun goToNextFragment(userName: String) {
        addFragmentBackStack(
            R.id.mainFragmentContainer, UserRepositoriesFragment.newInstance(userName),
            UserRepositoriesFragment.TAG
        )
    }

    companion object {
        private const val TAG = "LandingFragment"
        fun newInstance(): LandingFragment {
            return LandingFragment()
        }
    }
}