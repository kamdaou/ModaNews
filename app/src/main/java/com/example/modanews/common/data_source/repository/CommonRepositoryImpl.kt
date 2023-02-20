package com.example.modanews.common.data_source.repository

import com.example.modanews.common.data_source.local.CommonDao
import com.example.modanews.common.domain.model.Article
import com.example.modanews.common.domain.model.User
import com.example.modanews.common.domain.repository.ICommonRepository
import kotlinx.coroutines.flow.Flow

class CommonRepositoryImpl(private val dao: CommonDao) : ICommonRepository {
    override suspend fun getArticle(articleId: String): Article {
        return dao.getArticle(articleId)
    }

    override suspend fun getArticles(): Flow<List<Article>> {
        return dao.getArticles()
    }

    override suspend fun getUser(userId: String): User {
        return dao.getUser(userId)
    }
}