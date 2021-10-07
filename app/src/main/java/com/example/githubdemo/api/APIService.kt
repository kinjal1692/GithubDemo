package com.example.githubdemo.api

import com.example.githubdemo.BuildConfig
import com.example.githubdemo.model.Repo
import com.example.githubdemo.model.SearchResult
import com.example.githubdemo.util.AppConstants
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface APIService {

    companion object Factory {

        private val gson = GsonBuilder().setLenient().create()

        fun create(
            domain: String = BuildConfig.DOMAIN
        ): APIService {
            val interceptor = Interceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .build()
                )
            }

            val client = OkHttpClient().newBuilder()
                .callTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
            client.networkInterceptors().add(interceptor)

            val retrofit = Retrofit.Builder()
                .baseUrl(domain)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit.create(APIService::class.java)
        }
    }

    // suspend modifier indicates that the following function will execute in a coroutine (similar to a thread) allowing us
    // to keep the UI thread unblocked while long lasting operations
    @GET("repositories")
    suspend fun getTrendingRepos(
        @Query("q") keyword: String = " ",
        @Query("sort") sort: String = AppConstants.QUERY_SORT,
        @Query("order") order: String = AppConstants.QUERY_ORDER,
        @Query("per_page") per_page: Int = AppConstants.PAGE_SIZE,
        @Query("page") page: Int = 1
    ): Response<List<Repo>>

    @GET("search/repositories")
    suspend fun getSearchResults(
        @Query("q") keyword: String = "android",
        @Query("sort") sort: String = AppConstants.QUERY_SORT,
        @Query("order") order: String = AppConstants.QUERY_ORDER,
        @Query("per_page") per_page: Int = AppConstants.PAGE_SIZE,
        @Query("page") page: Int = 1
    ): Response<SearchResult>

    @GET("repositories")
    suspend fun getRepoDetail(): Response<Repo>
}
