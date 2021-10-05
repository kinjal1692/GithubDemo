package com.example.githubdemo.ui

import androidx.recyclerview.widget.RecyclerView

interface ItemClickListener {
    fun onItemClicked(holder: RecyclerView.ViewHolder, obj: Any?)
}