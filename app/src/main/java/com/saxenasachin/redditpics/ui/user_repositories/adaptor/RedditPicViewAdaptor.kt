package com.saxenasachin.redditpics.ui.user_repositories.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saxenasachin.presentation.views.views.ChildDataView
import com.saxenasachin.redditpics.R

/**
Created by Sachin Saxena on 19/06/22.
 */
class RedditPicViewAdaptor(
    private val listOfPics: List<ChildDataView>,
    val onItemCLickListener: OnItemCLickListener
) :
    RecyclerView.Adapter<RedditPicViewAdaptor.RedditPicViewHolder>() {

    interface OnItemCLickListener {
        fun onRepoClick(repoView: ChildDataView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditPicViewHolder {
        return RedditPicViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_single_user_repository_item, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfPics.size
    }

    override fun onBindViewHolder(holder: RedditPicViewHolder, position: Int) {
        holder.bind(listOfPics[position])
    }

    inner class RedditPicViewHolder(private val mView: View) :
        RecyclerView.ViewHolder(mView) {

        fun bind(repoView: ChildDataView) {
//            mView.tvRepoName.text = repoView.repoName
//            mView.tvRepoDesc.text = repoView.repoDescription
//            mView.tvRepoForkCount.text = repoView.forksCount.toString()
            onClicks(repoView)
        }

        private fun onClicks(repoView: ChildDataView) {
            mView.setOnClickListener {
                onItemCLickListener.onRepoClick(repoView)
            }
        }
    }
}