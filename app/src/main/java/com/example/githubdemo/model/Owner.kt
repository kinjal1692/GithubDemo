package com.example.githubdemo.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Owner")
data class Owner(
    var login: String? = "",

    @PrimaryKey
    var id: Long = 0L,

    @SerializedName("node_id")
    var nodeID: String? = "",

    @SerializedName("avatar_url")
    var avatarURL: String? = "",

    @SerializedName("gravatar_id")
    var gravatarID: String? = "",

    var url: String? = "",

    @SerializedName("html_url")
    var htmlURL: String? = "",

    @SerializedName("followers_url")
    var followersURL: String? = "",

    @SerializedName("following_url")
    var followingURL: String? = "",

    @SerializedName("gists_url")
    var gistsURL: String? = "",

    @SerializedName("starred_url")
    var starredURL: String? = "",

    @SerializedName("subscriptions_url")
    var subscriptionsURL: String? = "",

    @SerializedName("organizations_url")
    var organizationsURL: String? = "",

    @SerializedName("repos_url")
    var reposURL: String? = "",

    @SerializedName("events_url")
    var eventsURL: String? = "",

    @SerializedName("received_events_url")
    var receivedEventsURL: String? = "",

    var type: String? = "",

    @SerializedName("site_admin")
    var siteAdmin: Boolean = false
) {
    companion object {
        @Ignore
        var TableName = "Owner"
    }

    constructor() : this("", 0L, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", false)

}