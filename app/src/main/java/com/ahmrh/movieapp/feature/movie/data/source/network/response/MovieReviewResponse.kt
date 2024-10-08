package com.ahmrh.movieapp.feature.movie.data.source.network.response

import com.google.gson.annotations.SerializedName

data class MovieReviewResponse(

	@field:SerializedName("author_details")
	val authorDetails: AuthorDetails? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class AuthorDetails(

	@field:SerializedName("avatar_path")
	val avatarPath: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("username")
	val username: String? = null
)