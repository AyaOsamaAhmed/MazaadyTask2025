package com.aya.mazaadytask.di

import android.content.Context
import androidx.room.Room
import com.aya.data.database.AppDatabase
import com.aya.data.database.MovieDao
import com.aya.data.utils.Constant.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): MovieDao {
        return database.movieDao()
    }
}
