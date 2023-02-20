package com.example.modanews.feature_news.data.repository

import com.example.modanews.feature_news.data.data_source.remote.ArticleLikeDto
import com.example.modanews.feature_news.data.data_source.remote.CommentDto
import com.example.modanews.feature_news.data.data_source.remote.CommentLikeDto
import com.example.modanews.common.data_source.remote.UserDto
import com.example.modanews.feature_news.domain.repository.INewsRepository

class NewsRepositoryImpl : INewsRepository {

    override suspend fun getComments(): List<CommentDto> {
        TODO("implement the getComments function")
    }

    override suspend fun getComment(commentId: String): CommentDto {
        TODO("Not yet implemented")
    }

    override suspend fun addComment(comment: CommentDto) {
        TODO("Not yet implemented")
    }

    override suspend fun addCommentLike(like: CommentLikeDto, commentId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun addArticleLike(like: ArticleLikeDto, articleId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(userId: String): UserDto {
        TODO("Not yet implemented")
    }
}