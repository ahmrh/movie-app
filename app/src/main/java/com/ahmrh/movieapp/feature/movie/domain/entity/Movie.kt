package com.ahmrh.movieapp.feature.movie.domain.entity

data class Movie(
    val id: Int,

    val title: String,
    val vote: Double,
    val genre: List<Genre>,
    val imagePath: String,

    val overview: String? = null,
    val runtime: Int? = null,
    val language: String? = null,
    val reviews: List<Review>? = null,
){
    companion object {
        val PLACEHOLDER_MOVIE = Movie(
            1,
            "Placeholder Movie",
            7.5,
            listOf(
                Genre.PLACEHOLDER_GENRE,
                Genre.PLACEHOLDER_GENRE,
                Genre.PLACEHOLDER_GENRE
            ),
            "https://example.com/placeholder.jpg",
            "This is a placeholder overview.",
            120,
            "English",
            listOf(
                Review.PLACEHOLDER_REVIEW,
                Review.PLACEHOLDER_REVIEW,
                Review.PLACEHOLDER_REVIEW
            )
        )
    }
}
