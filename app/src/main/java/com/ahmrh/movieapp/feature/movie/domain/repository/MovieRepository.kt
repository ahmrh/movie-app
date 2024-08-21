package com.ahmrh.movieapp.feature.movie.domain.repository

import arrow.core.Either
import com.ahmrh.movieapp.core.exception.NetworkError
import com.ahmrh.movieapp.core.ui.navigation.Destination
import com.ahmrh.movieapp.feature.movie.domain.entity.Movie
import java.util.concurrent.Flow

interface MovieRepository {

    suspend fun getMovies(): Either<NetworkError, List<Movie>>
}