package com.example.modanews.feature_news.domain.repository

import com.example.modanews.common.domain.model.User
import com.example.modanews.feature_news.domain.model.ArticleLike
import com.example.modanews.feature_news.domain.model.Comment
import com.example.modanews.feature_news.domain.model.CommentLike
import kotlinx.coroutines.flow.Flow

interface INewsRepository {
    fun getComments(): Flow<List<Comment>>

    suspend fun getComment(commentId: String): Comment?

    suspend fun addComment(comment: Comment)

    suspend fun addCommentLike(like: CommentLike)

    suspend fun addArticleLike(like: ArticleLike)

    suspend fun getUser(userId: String): User?
}