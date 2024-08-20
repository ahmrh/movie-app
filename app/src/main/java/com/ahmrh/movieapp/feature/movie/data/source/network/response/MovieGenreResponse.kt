package com.ahmrh.movieapp.feature.movie.data.source.network.response

import com.google.gson.annotations.SerializedName

data class MovieGenreResponse(

	@field:SerializedName("genres")
	val genres: List<GenresItem?>? = null
)

data class GenresItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
