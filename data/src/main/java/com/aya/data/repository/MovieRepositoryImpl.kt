package com.aya.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.aya.data.api.MovieApis
import com.aya.data.database.MovieDao
import com.aya.data.database.MovieEntity
import com.aya.data.paging.MoviesRemoteMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApis,
    private val dao: MovieDao
) : MovieRepository {


    @OptIn(ExperimentalPagingApi::class)
    override fun getMovies(): Flow<PagingData<MovieEntity>> {
        val pagingSourceFactory = { dao.getAllMovies() }

        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = MoviesRemoteMediator(api, dao),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override suspend fun toggleFavorite(movieId: Long, isFavorite: Boolean) {
        dao.updateFavorite(movieId, isFavorite)
    }

    override suspend fun getMovie(movieId: Long):Flow<MovieEntity> {
       return dao.getMovieById(movieId)
    }

}