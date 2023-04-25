package com.example.photobook

data class Post (
    val id : Int,
    val accountName: String,
    val postedOn : String?,
    val imageId : Int?,
    val caption : String?,
    var likes : Int = 0,
    var isLiked : Boolean
)