package com.example.modanews.feature_admin.data.data_source.remote

data class ArticleLikeDto (
    val likeId: String,
    val score: Boolean,
    val user: UserDto
)
