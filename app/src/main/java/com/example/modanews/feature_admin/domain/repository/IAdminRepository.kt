package com.example.modanews.feature_admin.domain.repository

import com.example.modanews.common.data_source.remote.ArticleDto
import com.example.modanews.common.domain.model.Article

interface IAdminRepository {
    suspend fun setArticle(article: Article)

    suspend fun updateArticle(article: Article)
}