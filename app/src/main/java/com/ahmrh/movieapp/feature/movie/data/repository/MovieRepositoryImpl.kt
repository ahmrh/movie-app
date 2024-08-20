package com.ahmrh.movieapp.feature.movie.data.repository

import com.ahmrh.movieapp.feature.movie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(

): MovieRepository{


    companion object{
        const val TAG = "Movie Repository Implementation"
    }
}