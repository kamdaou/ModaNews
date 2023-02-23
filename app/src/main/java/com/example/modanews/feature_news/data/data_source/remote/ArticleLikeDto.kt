package com.example.modanews.feature_news.data.data_source.remote

import com.example.modanews.common.data_source.remote.UserDto

data class ArticleLikeDto (
    val likeId: String,
    val score: Boolean,
    val user: UserDto
)
