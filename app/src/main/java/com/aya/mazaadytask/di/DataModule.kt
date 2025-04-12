package com.aya.mazaadytask.di

import com.aya.data.repository.MovieRepository
import com.aya.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(
        impl: MovieRepositoryImpl
    ): MovieRepository

}