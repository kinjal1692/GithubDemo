package com.example.githubdemo.room

import androidx.room.TypeConverter
import com.example.githubdemo.model.Item
import com.example.githubdemo.model.License
import com.example.githubdemo.model.Owner
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OwnerTypeConverters {

    @TypeConverter
    fun ownerToString(owner: Owner): String = Gson().toJson(owner)

    @TypeConverter
    fun stringToOwner(string: String): Owner = Gson().fromJson(string, Owner::class.java)
}

class ItemTypeConverters {
    @TypeConverter
    fun itemToString(item: List<Item>): String =
        Gson().toJson(item, object : TypeToken<ArrayList<Item>>() {}.type)

    @TypeConverter
    fun stringToItem(string: String): List<Item> =
        Gson().fromJson(string, object : TypeToken<ArrayList<Item>>() {}.type)
}

class LicenseTypeConverters {
    @TypeConverter
    fun licenseToString(license: License): String = Gson().toJson(license)

    @TypeConverter
    fun stringToLicense(string: String): License = Gson().fromJson(string, License::class.java)

}