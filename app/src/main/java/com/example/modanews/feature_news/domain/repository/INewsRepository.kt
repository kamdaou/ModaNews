package com.example.modanews.feature_news.domain.repository

import com.example.modanews.feature_news.data.data_source.remote.ArticleLikeDto
import com.example.modanews.feature_news.data.data_source.remote.CommentDto
import com.example.modanews.feature_news.data.data_source.remote.CommentLikeDto
import com.example.modanews.common.data_source.remote.UserDto

interface INewsRepository {
    suspend fun getComments(): List<CommentDto>

    suspend fun getComment(commentId: String): CommentDto

    suspend fun addComment(comment: CommentDto)

    suspend fun addCommentLike(like: CommentLikeDto, commentId: String)

    suspend fun addArticleLike(like: ArticleLikeDto, articleId: String)

    suspend fun getUser(userId: String): UserDto
}