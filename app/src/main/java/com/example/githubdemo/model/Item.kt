package com.example.githubdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Item(
    @PrimaryKey
    var id: Long = 0L,

    @SerializedName("node_id")
    var nodeID: String = "",

    var name: String = "",

    @SerializedName("full_name")
    var fullName: String = "",

    var owner: Owner = Owner(),
    var private: Boolean = false,

    @SerializedName("html_url")
    var htmlURL: String = "",

    var description: String = "",
    var fork: Boolean = false,
    var url: String = "",

    @SerializedName("created_at")
    var createdAt: String = "",

    @SerializedName("updated_at")
    var updatedAt: String = "",

    @SerializedName("pushed_at")
    var pushedAt: String = "",

    var homepage: String = "",
    var size: Long = 0L,

    @SerializedName("stargazers_count")
    var stargazersCount: Long = 0L,

    @SerializedName("watchers_count")
    var watchersCount: Long = 0L,

    var language: String? = "",

    @SerializedName("forks_count")
    var forksCount: Long = 0L,

    @SerializedName("open_issues_count")
    var openIssuesCount: Long = 0L,

    @SerializedName("master_branch")
    var masterBranch: String = "",

    @SerializedName("default_branch")
    var defaultBranch: String = "",

    var score: Long = 0L,

    @SerializedName("archive_url")
    var archiveURL: String = "",

    @SerializedName("assignees_url")
    var assigneesURL: String = "",

    @SerializedName("blobs_url")
    var blobsURL: String = "",

    @SerializedName("branches_url")
    var branchesURL: String = "",

    @SerializedName("collaborators_url")
    var collaboratorsURL: String = "",

    @SerializedName("comments_url")
    var commentsURL: String = "",

    @SerializedName("commits_url")
    var commitsURL: String = "",

    @SerializedName("compare_url")
    var compareURL: String = "",

    @SerializedName("contents_url")
    var contentsURL: String = "",

    @SerializedName("contributors_url")
    var contributorsURL: String = "",

    @SerializedName("deployments_url")
    var deploymentsURL: String = "",

    @SerializedName("downloads_url")
    var downloadsURL: String = "",

    @SerializedName("events_url")
    var eventsURL: String = "",

    @SerializedName("forks_url")
    var forksURL: String = "",

    @SerializedName("git_commits_url")
    var gitCommitsURL: String = "",

    @SerializedName("git_refs_url")
    var gitRefsURL: String = "",

    @SerializedName("git_tags_url")
    var gitTagsURL: String = "",

    @SerializedName("git_url")
    var gitURL: String = "",

    @SerializedName("issue_comment_url")
    var issueCommentURL: String = "",

    @SerializedName("issue_events_url")
    var issueEventsURL: String = "",

    @SerializedName("issues_url")
    var issuesURL: String = "",

    @SerializedName("keys_url")
    var keysURL: String = "",

    @SerializedName("labels_url")
    var labelsURL: String = "",

    @SerializedName("languages_url")
    var languagesURL: String = "",

    @SerializedName("merges_url")
    var mergesURL: String = "",

    @SerializedName("milestones_url")
    var milestonesURL: String = "",

    @SerializedName("notifications_url")
    var notificationsURL: String = "",

    @SerializedName("pulls_url")
    var pullsURL: String = "",

    @SerializedName("releases_url")
    var releasesURL: String = "",

    @SerializedName("ssh_url")
    var sshURL: String = "",

    @SerializedName("stargazers_url")
    var stargazersURL: String = "",

    @SerializedName("statuses_url")
    var statusesURL: String = "",

    @SerializedName("subscribers_url")
    var subscribersURL: String = "",

    @SerializedName("subscription_url")
    var subscriptionURL: String = "",

    @SerializedName("tags_url")
    var tagsURL: String = "",

    @SerializedName("teams_url")
    var teamsURL: String = "",

    @SerializedName("trees_url")
    var treesURL: String = "",

    @SerializedName("clone_url")
    var cloneURL: String = "",

    @SerializedName("mirror_url")
    var mirrorURL: String = "",

    @SerializedName("hooks_url")
    var hooksURL: String = "",

    @SerializedName("svn_url")
    var svnURL: String = "",

    var forks: Long,

    @SerializedName("open_issues")
    var openIssues: Long,

    var watchers: Long,

    @SerializedName("has_issues")
    var hasIssues: Boolean,

    @SerializedName("has_projects")
    var hasProjects: Boolean,

    @SerializedName("has_pages")
    var hasPages: Boolean,

    @SerializedName("has_wiki")
    var hasWiki: Boolean,

    @SerializedName("has_downloads")
    var hasDownloads: Boolean,

    var archived: Boolean,
    var disabled: Boolean,
    var visibility: String = "",
    var license: License
) {
    constructor() : this(
        -1,
        "",
        "",
        "",
        Owner(),
        false,
        "",
        "",
        false,
        "",
        "",
        "",
        "",
        "",
        0L,
        0L,
        0L,
        "",
        0L,
        0L,
        "",
        "",
        0L,
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
        "",
        "",
        "",
        "",
        "",
        0L,
        0L,
        0L,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        "",
        License()
    )
}