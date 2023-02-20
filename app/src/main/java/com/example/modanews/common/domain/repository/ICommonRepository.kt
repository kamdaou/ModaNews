package com.example.modanews.common.domain.repository

import com.example.modanews.common.domain.model.Article
import com.example.modanews.common.domain.model.User
import kotlinx.coroutines.flow.Flow

interface ICommonRepository {
    suspend fun getArticle(articleId: String): Article

    suspend fun getArticles(): Flow<List<Article>>

    suspend fun getUser(userId: String): User
}