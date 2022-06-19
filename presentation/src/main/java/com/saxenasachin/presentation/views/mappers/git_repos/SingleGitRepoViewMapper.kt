package com.saxenasachin.presentation.views.mappers.git_repos

import com.saxenasachin.domain.models.repo.GitSingleRepo
import com.saxenasachin.presentation.mapper.Mapper
import com.saxenasachin.presentation.views.views.SingleRepoView
import javax.inject.Inject

class SingleGitRepoViewMapper @Inject constructor() : Mapper<SingleRepoView, GitSingleRepo> {

    override fun mapToView(type: GitSingleRepo): SingleRepoView {
        return SingleRepoView(
            repoName = type.repoName,
            repoDescription = type.repoDescription,
            forksCount = type.forksCount
        )
    }
}