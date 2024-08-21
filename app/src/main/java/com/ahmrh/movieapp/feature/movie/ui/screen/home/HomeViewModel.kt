package com.ahmrh.movieapp.feature.movie.ui.screen.home

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.ahmrh.movieapp.core.state.UiState
import com.ahmrh.movieapp.feature.movie.domain.entity.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): ViewModel() {

    private var _nowShowingMovieUiState: MutableStateFlow<UiState<List<Movie>>>
        = MutableStateFlow(UiState.Idle)
    val nowShowingMovieUiState: StateFlow<UiState<List<Movie>>>
        get() = _nowShowingMovieUiState


    private var _popularMovieUiState: MutableStateFlow<UiState<List<Movie>>>
            = MutableStateFlow(UiState.Idle)
    val popularMovieUiState: StateFlow<UiState<List<Movie>>>
        get() = _popularMovieUiState

    fun getMovies() {

    }
}