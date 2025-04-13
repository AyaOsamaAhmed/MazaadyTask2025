package com.aya.data.api

import com.aya.data.model.MovieResponse
import com.aya.data.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApis {
    @GET("3/movie/now_playing")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = Constant.apiKey,
        @Query("page") page: Int
    ): MovieResponse
}