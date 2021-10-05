package com.example.githubdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.githubdemo.model.Repo
import com.example.githubdemo.api.Repository
import com.example.githubdemo.api.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GithubRepoViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    var repoResult: LiveData<Resource<List<Repo>>>? = repository.getRepos()

}