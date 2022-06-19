package com.saxenasachin.data.mapper.single_repo

import com.saxenasachin.data.mapper.Mapper
import com.saxenasachin.data.models.SingleRepoEntity
import com.saxenasachin.domain.models.repo.GitSingleRepo
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class SingleRepoMapper @Inject constructor() : Mapper<SingleRepoEntity, GitSingleRepo> {
    override fun mapFromEntity(type: SingleRepoEntity): GitSingleRepo {
        return GitSingleRepo(
            repoName = type.repoName,
            defaultBranch = type.defaultBranch,
            forksCount = type.forksCount,
            openIssuesCount = type.openIssuesCount,
            repoDescription = type.repoDescription
        )
    }

    override fun mapToEntity(type: GitSingleRepo): SingleRepoEntity {
        return SingleRepoEntity(
            repoName = type.repoName,
            defaultBranch = type.defaultBranch,
            forksCount = type.forksCount,
            openIssuesCount = type.openIssuesCount,
            repoDescription = type.repoDescription
        )
    }
}