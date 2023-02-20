package com.example.modanews.common.domain.repository

import com.example.modanews.common.data_source.remote.ArticleDto
import com.example.modanews.common.data_source.remote.UserDto

interface ICommonRepository {
    suspend fun getArticle(articleId: String): ArticleDto

    suspend fun getArticles(): List<ArticleDto>

    suspend fun getUser(userId: String): UserDto
}