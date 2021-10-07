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

    fun getRepos() = performGetOperation(
        databaseQuery = { localDataSource.getAllRepository() },
        networkCall = { remoteDataSource.getRepos() },
        saveCallResult = { localDataSource.insertAll(it) }
    )

    fun getSearchResults() = performGetOperation(
        databaseQuery = { localDataSource.getSearchResult() },
        networkCall = { remoteDataSource.getSearchResult() },
        saveCallResult = { localDataSource.insertSearchResult(it) }
    )

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