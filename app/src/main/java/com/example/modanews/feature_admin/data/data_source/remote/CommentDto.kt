package com.example.modanews.feature_admin.data.data_source.remote

data class CommentDto (
    val commentId: String,
    val articleId: String,
    val content: String,
    val user: UserDto,
    val likes: List<CommentLikeDto>,
)
