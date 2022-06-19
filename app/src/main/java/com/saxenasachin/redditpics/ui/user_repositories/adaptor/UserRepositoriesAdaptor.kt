package com.saxenasachin.redditpics.ui.user_repositories.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saxenasachin.presentation.views.views.SingleRepoView
import com.saxenasachin.redditpics.R
import kotlinx.android.synthetic.main.layout_single_user_repository_item.view.*

/**
Created by Sachin Saxena on 19/06/22.
 */
class UserRepositoriesAdaptor(
    private val listOfRepos: List<SingleRepoView>,
    val onItemCLickListener: OnItemCLickListener
) :
    RecyclerView.Adapter<UserRepositoriesAdaptor.UserRepositoriesViewHolder>() {

    interface OnItemCLickListener {
        fun onRepoClick(repoView: SingleRepoView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRepositoriesViewHolder {
        return UserRepositoriesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_single_user_repository_item, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfRepos.size
    }

    override fun onBindViewHolder(holder: UserRepositoriesViewHolder, position: Int) {
        holder.bind(listOfRepos[position])
    }

    inner class UserRepositoriesViewHolder(private val mView: View) :
        RecyclerView.ViewHolder(mView) {

        fun bind(repoView: SingleRepoView) {
            mView.tvRepoName.text = repoView.repoName
            mView.tvRepoDesc.text = repoView.repoDescription
            mView.tvRepoForkCount.text = repoView.forksCount.toString()
            onClicks(repoView)
        }

        private fun onClicks(repoView: SingleRepoView) {
            mView.setOnClickListener {
                onItemCLickListener.onRepoClick(repoView)
            }
        }
    }
}