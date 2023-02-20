package com.example.modanews.feature_admin.data.repository

import com.example.modanews.common.data_source.remote.ArticleDto
import com.example.modanews.feature_admin.domain.repository.IAdminRepository

class AdminRepositoryImpl : IAdminRepository {

    override suspend fun setArticle(article: ArticleDto) {
        TODO ("implement setArticle")
    }

    override suspend fun updateArticle(article: ArticleDto) {
        TODO("Not yet implemented")
    }

}