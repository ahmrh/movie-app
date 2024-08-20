package com.ahmrh.movieapp.feature.movie.domain.entity

data class Genre(
    val id: Int,
    val name: String,
){
    companion object{
        val PLACEHOLDER_GENRE = Genre(
            28,
            "Action"
        )
    }
}
