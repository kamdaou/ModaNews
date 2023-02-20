package com.example.modanews.feature_admin.domain.repository

import com.example.modanews.common.data_source.remote.ArticleDto

interface IAdminRepository {
    suspend fun setArticle(article: ArticleDto)

    suspend fun updateArticle(article: ArticleDto)
}