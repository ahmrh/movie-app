package com.ahmrh.movieapp.core.di

import com.ahmrh.movieapp.feature.movie.data.repository.MovieRepositoryImpl
import com.ahmrh.movieapp.feature.movie.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(impl: MovieRepositoryImpl) : MovieRepository
}