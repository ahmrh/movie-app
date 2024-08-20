package com.ahmrh.movieapp.feature.movie.domain.entity

import com.ahmrh.movieapp.core.ui.navigation.Destination

data class Review(
    val author: String,
    val content: String,
    val createdAt: String,
    val updatedAt: String,
) {
    companion object {
        val PLACEHOLDER_REVIEW = Review(
            "John Doe",
            "Placeholder review content",
            "2023-11-22T10:30:00Z",
            "2023-11-22T10:30:00Z"
        )
    }
}