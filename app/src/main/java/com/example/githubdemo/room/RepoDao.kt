package com.example.githubdemo.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubdemo.model.Repo

@Dao
interface RepoDao {

    @Query("SELECT * FROM GithubRepository")
    fun getAllRepository(): LiveData<List<Repo>>

    @Query("SELECT * FROM GithubRepository WHERE id = :id")
    fun getRepository(id: Int): LiveData<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repo: List<Repo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: Repo)

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: Repo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(repos: List<Repo>)

    @Query("SELECT * FROM GithubRepository")
    fun getAllRepos(repos: List<Repo>)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg repos: Repo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertRepos(repositories: List<Repo>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun createRepoIfNotExists(repo: Repo): Long

    @Query("SELECT * FROM Repo WHERE name = :name")
    abstract fun load(ownerLogin: String, name: String): LiveData<Repo>

    @Query("SELECT * FROM Repo ORDER BY stars DESC")
    abstract fun loadRepositories(owner: String): List<Repo>

    *//*@Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(result: RepoSearchResult)

    @Query("SELECT * FROM RepoSearchResult WHERE `query` = :query")
    abstract fun search(query: String): LiveData<RepoSearchResult?>*//*

    fun loadOrdered(repoIds: List<Int>): LiveData<List<Repo>> {
        val order = SparseIntArray()
        repoIds.withIndex().forEach {
            order.put(it.value, it.index)
        }
        return loadById(repoIds).map { repositories ->
            repositories.sortedWith(compareBy { order.get(it.id) })
        }
    }*/

    /* @Query("SELECT * FROM Repo WHERE id in (:id)")
     protected abstract fun loadById(repoIds: List<Int>): LiveData<List<Repo>>*/

}