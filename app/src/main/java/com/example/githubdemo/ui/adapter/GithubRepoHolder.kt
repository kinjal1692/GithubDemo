package com.example.githubdemo.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubdemo.R
import com.example.githubdemo.model.Item
import com.example.githubdemo.model.Repo
import com.example.githubdemo.util.*
import kotlinx.android.synthetic.main.row_repository.view.*

class GithubRepoHolder(private var v: View) : RecyclerView.ViewHolder(v) {

    fun setData(itemObject: Any) {
        if (itemObject is Repo) {
            v.repoNameTv.text = itemObject.fullName
        }
        if (itemObject is Item) {
            v.repoNameTv.text = itemObject.fullName
            v.repoDescTv.text = itemObject.description
            v.createdLbl.text =
                "${v.context.getString(R.string.lbl_created_by)} ${itemObject.owner.login}"

            // Stargazers
            v.starsTv.background =
                getBgDrawable(
                    v.context,
                    R.color.purple_70,
                    R.dimen.corner_radius_small,
                    R.dimen.corner_radius_small,
                    R.dimen.corner_radius_small,
                    R.dimen.corner_radius_small
                )
            v.starsTv.text = "${prettyCount(itemObject.stargazersCount)}"

            // Language
            v.langTv.background =
                getBgDrawable(
                    v.context,
                    R.color.purple_70,
                    R.dimen.corner_radius_small,
                    R.dimen.corner_radius_small,
                    R.dimen.corner_radius_small,
                    R.dimen.corner_radius_small
                )
            v.langTv.text = itemObject.language
            if (itemObject.language.isNullOrEmpty()) {
                v.langTv.makeGone()
            } else v.langTv.makeVisible()

            // Updated date
            v.updatedAtTv.text = formatDate(
                itemObject.updatedAt,
                DF_YYYY_MM_DD_T_HH_MM_SS_GMT, DF_DD_MMMM
            )

            Glide.with(v.context)
                .load(itemObject.owner.avatarURL)
                .centerCrop()
                .into(v.ownerIv)
        }
    }

}