package com.example.githubdemo.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.githubdemo.datasource.RepoRemoteDataSource
import com.example.githubdemo.room.RepoDao
import kotlinx.coroutines.Dispatchers

/**
 * Repository that handles Repo instances.
 */
class Repository(
    private val remoteDataSource: RepoRemoteDataSource,
    private val localDataSource: RepoDao
) {

    /*fun getRepo(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getRepository(id) },
        networkCall = { remoteDataSource.getRepoDe() },
        saveCallResult = { localDataSource.insert(it) }
    )*/

    fun getRepos() = performGetOperation(
        databaseQuery = { localDataSource.getAllRepository() },
        networkCall = { remoteDataSource.getRepos() },
        saveCallResult = { localDataSource.insertAll(it) }
    )

    /*fun loadRepos(owner: String): Resource<List<Repo>> {
        return object : NetworkBoundResource<List<Repo>, List<Repo>>(appExecutors) {
            override suspend fun saveCallResult(item: List<Repo>) {
                repoDao.insertRepos(item)
            }

            override fun shouldFetch(data: List<Repo>?): Boolean {
                return data == null || data.isEmpty() || rateLimiter.shouldFetch(owner)
            }

            override suspend fun loadFromDb(): List<Repo> = repoDao.loadRepositories(owner)

            override fun createCall(): ApiResponse<List<Repo>> =
                githubService.getTrendingRepos()

            override fun onFetchFailed() {
                rateLimiter.reset(owner)
            }
        }
    }

    fun getTrendingRepos() = object : NetworkBoundResource<ArrayList<Repo>, ArrayList<Repo>>(
        appExecutors
    ) {
        override suspend fun saveCallResult(item: ArrayList<Repo>) {
            repoDao.insertAll(item)
        }

        override fun shouldFetch(data: ArrayList<Repo>?): Boolean {
            return rateLimiter.shouldFetch(userId) && (data == null || !shouldFetch(data))
        }

        override suspend fun loadFromDb(): Flow<User> {
            return userDao.load(userId)
        }

        override fun createCall(): Flow<ApiResponse<User>> {
            return webservice.getUser(userId)
        }
    }*/

}

interface APICallback {
    fun onResponse(data: String)
}

fun <T, A> performGetOperation(
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> Resource<A>,
    saveCallResult: suspend (A) -> Unit
): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val source = databaseQuery.invoke().map { Resource.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Resource.Status.SUCCESS) {
            saveCallResult(responseStatus.data!!)

        } else if (responseStatus.status == Resource.Status.ERROR) {
            emit(Resource.error(responseStatus.message!!))
            emitSource(source)
        }
    }