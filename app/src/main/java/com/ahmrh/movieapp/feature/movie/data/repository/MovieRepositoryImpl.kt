package com.ahmrh.movieapp.feature.movie.data.repository

import arrow.core.Either
import com.ahmrh.movieapp.core.exception.NetworkError
import com.ahmrh.movieapp.core.exception.toNetworkError
import com.ahmrh.movieapp.core.ui.navigation.Destination
import com.ahmrh.movieapp.feature.movie.data.source.network.service.MovieApi
import com.ahmrh.movieapp.feature.movie.domain.entity.Movie
import com.ahmrh.movieapp.feature.movie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi

): MovieRepository{


    override suspend fun getMovies(): Either<NetworkError, List<Movie>> {
        return Either.catch {
            movieApi.getNowPlayingMovies().results!!.map {
                // placeholder first
                Movie.PLACEHOLDER_MOVIE
            }
        }.mapLeft { it.toNetworkError() }
    }
    companion object{
        const val TAG = "Movie Repository Implementation"
    }
}