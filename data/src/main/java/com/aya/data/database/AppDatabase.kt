package com.aya.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aya.data.utils.Constant


@Database(entities = [MovieEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        const val DATABASE_NAME: String = Constant.DATABASE_NAME
    }

}