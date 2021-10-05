package com.example.githubdemo.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.githubdemo.model.Repo
import kotlinx.android.synthetic.main.row_repository.view.*

class GithubRepoHolder(private var v: View) : RecyclerView.ViewHolder(v) {

    fun setData(itemObject: Repo) {
        v.repoNameTv.text = itemObject.fullName
    }

}