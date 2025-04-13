package com.aya.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.aya.data.api.MovieApis
import com.aya.data.database.MovieDao
import com.aya.data.database.MovieEntity

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator(
    private val api: MovieApis,
    private val dao: MovieDao
) : RemoteMediator<Int, MovieEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) 1 else (state.pages.size + 1)
            }
        }

        return try {
            val response = api.getMovies(page = page)

            val movies = response.results?.map {
                MovieEntity(
                    id = it.id,
                    title = it.title,
                    posterPath = it.posterPath,
                    overview = it.overview,
                    releaseDate = it.releaseDate,
                    isFavorite = dao.getFavoritesNow().any { fav -> fav.id == it.id }
                )
            } ?: emptyList()


            if (loadType == LoadType.REFRESH) {
                dao.clearAll()
            }
            dao.insertAll(movies)

            MediatorResult.Success(endOfPaginationReached = response.results?.isEmpty() == true)

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}