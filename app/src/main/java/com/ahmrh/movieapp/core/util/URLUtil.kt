package com.ahmrh.movieapp.core.util

object URLUtil {

    fun imagePathToUrl(path: String): String {
        return "https://image.tmdb.org/t/p/original$path"
    }

    fun youtubePathToUrl(path: String): String {
        return "https://www.youtube.com/watch?v=$path"
    }
}