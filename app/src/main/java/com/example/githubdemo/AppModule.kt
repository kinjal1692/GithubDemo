package com.example.githubdemo

import android.content.Context
import com.example.githubdemo.datasource.RepoRemoteDataSource
import com.example.githubdemo.api.APIService
import com.example.githubdemo.api.Repository
import com.example.githubdemo.room.GithubDatabase
import com.example.githubdemo.room.RepoDao
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.DOMAIN)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(characterService: APIService) =
        RepoRemoteDataSource(characterService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        GithubDatabase.getInstance(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: GithubDatabase) = db.repoDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RepoRemoteDataSource,
        localDataSource: RepoDao
    ) =
        Repository(remoteDataSource, localDataSource)
}