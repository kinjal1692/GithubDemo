package com.example.githubdemo.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class License(
    @PrimaryKey
    var key: String = "",
    var name: String = "",
    var url: String = "",

    @SerializedName("spdx_id")
    var spdxID: String = "",

    @SerializedName("node_id")
    var nodeID: String = "",

    @SerializedName("html_url")
    var htmlURL: String = ""
) {
    constructor() : this("", "", "", "", "", "")
    companion object {
        @Ignore
        var TableName = "License"
    }
}