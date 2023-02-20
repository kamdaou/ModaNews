package com.example.modanews.feature_news.data.repository

import com.example.modanews.common.domain.model.User
import com.example.modanews.feature_news.data.data_source.local.NewsDao
import com.example.modanews.feature_news.domain.model.ArticleLike
import com.example.modanews.feature_news.domain.model.Comment
import com.example.modanews.feature_news.domain.model.CommentLike
import com.example.modanews.feature_news.domain.repository.INewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsDao: NewsDao) : INewsRepository {

    override fun getComments(): Flow<List<Comment>> {
        return newsDao.getComments()
    }

    override suspend fun getComment(commentId: String): Comment {
        return newsDao.getComment(commentId)
    }

    override suspend fun addComment(comment: Comment) {
        newsDao.addComment(comment)
    }

    override suspend fun addCommentLike(like: CommentLike) {
        newsDao.addCommentLike(like)
    }

    override suspend fun addArticleLike(like: ArticleLike) {
        newsDao.addArticleLike(like)
    }

    override suspend fun getUser(userId: String): User {
        return newsDao.getUser(userId)
    }
}