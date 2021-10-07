package com.example.githubdemo.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "SearchResult")
data class SearchResult(
    @PrimaryKey(autoGenerate = true)
    var id: Int = -1,

    @SerializedName("total_count")
    var totalCount: Long,

    @SerializedName("incomplete_results")
    var incompleteResults: Boolean,

    var items: List<Item>
) {
    companion object {
        @Ignore
        var TableName = "SearchResult"
    }
    
    constructor() : this(-1, 0L, false, ArrayList<Item>())
}

