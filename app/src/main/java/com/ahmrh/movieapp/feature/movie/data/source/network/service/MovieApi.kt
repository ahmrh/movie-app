package com.ahmrh.movieapp.feature.movie.data.source.network.service

import com.ahmrh.movieapp.feature.movie.data.source.network.response.NowPlayingMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("language") language: String = "en-US",
    ): NowPlayingMovieResponse
}