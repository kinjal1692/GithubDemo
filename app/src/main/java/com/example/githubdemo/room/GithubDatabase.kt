package com.example.githubdemo.room

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.githubdemo.model.*

@TypeConverters(OwnerTypeConverters::class, ItemTypeConverters::class, LicenseTypeConverters::class)
@Database(
    entities = [Repo::class, Owner::class, SearchResult::class,
        Item::class, License::class],
    version = 1,
    exportSchema = false
)

abstract class GithubDatabase : RoomDatabase() {

    abstract fun repoDao(): RepoDao

    companion object {
        @Volatile
        private var instance: GithubDatabase? = null

        @Synchronized
        fun getInstance(context: Context): GithubDatabase {
            if (instance != null) return instance!!

            synchronized(this) {
                instance =
                    Room.databaseBuilder(
                        context.applicationContext, GithubDatabase::class.java,
                        "github_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallBack)
                        .build()

                return instance!!
            }

        }

        private val roomCallBack: Callback = object : Callback() {
            override fun onCreate(@NonNull db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }
    }

}