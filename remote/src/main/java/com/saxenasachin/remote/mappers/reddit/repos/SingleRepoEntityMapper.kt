package com.saxenasachin.remote.mappers.reddit.repos

import com.saxenasachin.data.models.SingleRepoEntity
import com.saxenasachin.remote.mappers.EntityMapper
import com.saxenasachin.remote.models.repo.GithubSingleRepo
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class SingleRepoEntityMapper @Inject constructor() :
    EntityMapper<GithubSingleRepo, SingleRepoEntity> {

    override fun mapFromModel(model: GithubSingleRepo): SingleRepoEntity {
        return SingleRepoEntity(
            repoName = model.name ?: "",
            repoDescription = model.description ?: "",
            openIssuesCount = model.openIssuesCount ?: 0,
            forksCount = model.forksCount ?: 0,
            defaultBranch = model.defaultBranch ?: ""
        )
    }
}