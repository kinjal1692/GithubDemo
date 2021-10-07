package com.example.githubdemo.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubdemo.model.Repo
import com.example.githubdemo.model.SearchResult

@Dao
interface RepoDao {

    /* Repository */
    @Query("SELECT * FROM GithubRepository")
    fun getAllRepository(): LiveData<List<Repo>>

    @Query("SELECT * FROM GithubRepository WHERE id = :id")
    fun getRepository(id: Int): LiveData<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repo: List<Repo>)

    /* Search Repository */
    @Query("SELECT * FROM SearchResult")
    fun getSearchResult(): LiveData<SearchResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = SearchResult::class)
    suspend fun insertSearchResult(searchResult: SearchResult)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = SearchResult::class)
    suspend fun insert(searchResult: SearchResult)

}