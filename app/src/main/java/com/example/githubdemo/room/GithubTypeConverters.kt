package com.example.githubdemo.room

import androidx.room.TypeConverter
import com.example.githubdemo.model.Owner
import com.google.gson.Gson

class OwnerTypeConverters {

    @TypeConverter
    fun ownerToString(owner: Owner): String = Gson().toJson(owner)

    @TypeConverter
    fun stringToOwner(string: String): Owner = Gson().fromJson(string, Owner::class.java)

}