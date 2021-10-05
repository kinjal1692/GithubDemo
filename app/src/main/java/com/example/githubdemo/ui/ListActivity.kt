package com.example.githubdemo.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubdemo.R
import com.example.githubdemo.ui.adapter.RepoAdapter
import com.example.githubdemo.api.Resource
import com.example.githubdemo.viewmodel.GithubRepoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.row_paging_progressbar.*

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private var viewModel: GithubRepoViewModel? = null

    private var mAdapter: RepoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        init()
    }

    private fun init() {
        // Get the view model
        viewModel = ViewModelProvider(this).get(GithubRepoViewModel::class.java)

        recyclerView?.apply {
            layoutManager = LinearLayoutManager(
                this@ListActivity, LinearLayoutManager.VERTICAL, false
            )

            // Init adapter
            mAdapter = RepoAdapter(
                object : ItemClickListener {
                    override fun onItemClicked(holder: RecyclerView.ViewHolder, obj: Any?) {

                    }
                })
            adapter = mAdapter
        }
        getData()
    }

    private fun getData() {
        viewModel?.repoResult?.observe(this, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    showProgressbar(false)
                    if (!it.data.isNullOrEmpty()) {
                        mAdapter?.submitData(ArrayList(it.data))
                        mAdapter?.notifyDataSetChanged()
                    }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    showProgressbar(true)
            }
        })
    }

    private fun showProgressbar(show: Boolean) {
        // if (show) loader.makeVisible() else loader.makeGone()
    }

}