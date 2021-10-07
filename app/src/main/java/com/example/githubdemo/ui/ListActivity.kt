package com.example.githubdemo.ui

import android.accounts.Account
import android.accounts.AccountManager
import android.content.ContentResolver
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubdemo.R
import com.example.githubdemo.api.Resource
import com.example.githubdemo.ui.adapter.SearchResultAdapter
import com.example.githubdemo.viewmodel.GithubRepoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.row_paging_progressbar.*

// Constants
// The authority for the sync adapter's content provider
const val AUTHORITY = "com.example.githubdemo.provider"

// An account type, in the form of a domain name
const val ACCOUNT_TYPE = "example.com"

// The account name
const val ACCOUNT = "placeholderaccount"

const val SECONDS_PER_MINUTE = 60L
const val SYNC_INTERVAL_IN_MINUTES = 15L
const val SYNC_INTERVAL = SYNC_INTERVAL_IN_MINUTES *
        SECONDS_PER_MINUTE

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private lateinit var mAccount: Account

    private var viewModel: GithubRepoViewModel? = null
    private var mAdapter: SearchResultAdapter? = null
    // private var mAdapter: RepoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        mAccount = createSyncAccount()
        val resolver = contentResolver
        resolver.setIsSyncable(mAccount, AUTHORITY, 1)
        resolver.setSyncAutomatically(mAccount, AUTHORITY, true)
        resolver.addPeriodicSync(
            mAccount,
            CommonUtilities.AUTHORITY,
            Bundle.EMPTY,
            SYNC_INTERVAL
        )

        init()
    }

    /**
     * Create a new placeholder account for the sync adapter
     */
    private fun createSyncAccount(): Account {
        val accountManager = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
        return Account(ACCOUNT, ACCOUNT_TYPE).also { newAccount ->
            /*
             * Add the account and account type, no password or user data
             * If successful, return the Account object, otherwise report an error.
             */
            if (accountManager.addAccountExplicitly(newAccount, null, null)) {
                /*
                 * If you don't set android:syncable="true" in
                 * in your <provider> element in the manifest,
                 * then call context.setIsSyncable(account, AUTHORITY, 1)
                 * here.
                 */
                ContentResolver.setIsSyncable(newAccount, AUTHORITY, 1);
                ContentResolver.setMasterSyncAutomatically(true);
                ContentResolver.setSyncAutomatically(newAccount, AUTHORITY, true);
            } else {
                /*
                 * The account exists or some other error occurred. Log this, report it,
                 * or handle it internally.
                 */
            }
        }
    }

    private fun init() {

        // Get the view model
        viewModel = ViewModelProvider(this).get(GithubRepoViewModel::class.java)

        recyclerView?.apply {
            layoutManager = LinearLayoutManager(
                this@ListActivity, LinearLayoutManager.VERTICAL, false
            )

            // Init adapter
            mAdapter = SearchResultAdapter(
                object : ItemClickListener {
                    override fun onItemClicked(holder: RecyclerView.ViewHolder, obj: Any?) {

                    }
                })
            /*mAdapter = RepoAdapter(
                object : ItemClickListener {
                    override fun onItemClicked(holder: RecyclerView.ViewHolder, obj: Any?) {

                    }
                })*/
            adapter = mAdapter
        }
        getData()
    }

    private fun getData() {
        /*viewModel?.repoResult?.observe(this, {
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
        })*/
        viewModel?.searchResult?.observe(this, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    showProgressbar(false)
                    it.data?.let { result ->
                        if (!result.items.isNullOrEmpty()) {
                            mAdapter?.submitData(ArrayList(result.items))
                            mAdapter?.notifyDataSetChanged()
                        }
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