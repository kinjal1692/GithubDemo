package com.example.githubdemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView
import com.example.githubdemo.R
import com.example.githubdemo.model.Item
import com.example.githubdemo.model.Repo
import com.example.githubdemo.ui.ItemClickListener

class SearchResultAdapter(var itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<GithubRepoHolder>() {

    private var list: ArrayList<Item> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoHolder {
        return GithubRepoHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_repository, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GithubRepoHolder, position: Int) {
        getItem(position).let { repo ->
            holder.setData(repo)
            holder.itemView.setOnClickListener {
                itemClickListener.onItemClicked(holder, repo)
            }
        }
    }

    private fun getItem(@IntRange(from = 0) position: Int) = list[position]

    override fun getItemCount(): Int = list.size

    fun submitData(list: ArrayList<Item>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

}