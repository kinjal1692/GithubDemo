package com.example.githubdemo.datasource

import com.example.githubdemo.api.APIService
import javax.inject.Inject

/**
 * GetResult encapsulates the Retrofit response in a Resource, in order to handle errors better
 */
class RepoRemoteDataSource @Inject constructor(
    private val characterService: APIService
) : BaseDataSource() {

    suspend fun getRepos() =
        getResult { characterService.getTrendingRepos() }
}