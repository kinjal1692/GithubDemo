package com.example.githubdemo.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "GithubRepository")
data class Repo(

    @PrimaryKey
    var id: Long,

    @SerializedName("node_id")
    var nodeID: String?,

    var name: String?,

    @SerializedName("full_name")
    var fullName: String?,

    var private: Boolean,
    var owner: Owner,

    @SerializedName("html_url")
    var htmlURL: String?,

    var description: String?,
    var fork: Boolean,
    var url: String?,

    @SerializedName("forks_url")
    var forksURL: String?,

    @SerializedName("keys_url")
    var keysURL: String?,

    @SerializedName("collaborators_url")
    var collaboratorsURL: String?,

    @SerializedName("teams_url")
    var teamsURL: String?,

    @SerializedName("hooks_url")
    var hooksURL: String?,

    @SerializedName("issue_events_url")
    var issueEventsURL: String?,

    @SerializedName("events_url")
    var eventsURL: String?,

    @SerializedName("assignees_url")
    var assigneesURL: String?,

    @SerializedName("branches_url")
    var branchesURL: String?,

    @SerializedName("tags_url")
    var tagsURL: String?,

    @SerializedName("blobs_url")
    var blobsURL: String?,

    @SerializedName("git_tags_url")
    var gitTagsURL: String?,

    @SerializedName("git_refs_url")
    var gitRefsURL: String?,

    @SerializedName("trees_url")
    var treesURL: String?,

    @SerializedName("statuses_url")
    var statusesURL: String?,

    @SerializedName("languages_url")
    var languagesURL: String?,

    @SerializedName("stargazers_url")
    var stargazersURL: String?,

    @SerializedName("contributors_url")
    var contributorsURL: String?,

    @SerializedName("subscribers_url")
    var subscribersURL: String?,

    @SerializedName("subscription_url")
    var subscriptionURL: String?,

    @SerializedName("commits_url")
    var commitsURL: String?,

    @SerializedName("git_commits_url")
    var gitCommitsURL: String?,

    @SerializedName("comments_url")
    var commentsURL: String?,

    @SerializedName("issue_comment_url")
    var issueCommentURL: String?,

    @SerializedName("contents_url")
    var contentsURL: String?,

    @SerializedName("compare_url")
    var compareURL: String?,

    @SerializedName("merges_url")
    var mergesURL: String?,

    @SerializedName("archive_url")
    var archiveURL: String?,

    @SerializedName("downloads_url")
    var downloadsURL: String?,

    @SerializedName("issues_url")
    var issuesURL: String?,

    @SerializedName("pulls_url")
    var pullsURL: String?,

    @SerializedName("milestones_url")
    var milestonesURL: String?,

    @SerializedName("notifications_url")
    var notificationsURL: String?,

    @SerializedName("labels_url")
    var labelsURL: String?,

    @SerializedName("releases_url")
    var releasesURL: String?,

    @SerializedName("deployments_url")
    var deploymentsURL: String
) {
    companion object {
        @Ignore
        var TableName = "GithubRepository"
    }

    constructor() : this(
        0L,
        "",
        "",
        "",
        false,
        Owner(),
        "",
        "",
        false,
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )
}