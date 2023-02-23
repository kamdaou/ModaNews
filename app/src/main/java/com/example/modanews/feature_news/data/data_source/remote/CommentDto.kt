package com.example.modanews.feature_news.data.data_source.remote

import com.example.modanews.common.data_source.remote.UserDto

data class CommentDto (
    val commentId: String,
    val articleId: String,
    val content: String,
    val user: UserDto,
    val likes: List<CommentLikeDto>,
)
