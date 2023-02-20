package com.example.modanews.common.data_source.repository

import com.example.modanews.common.data_source.remote.ArticleDto
import com.example.modanews.common.data_source.remote.UserDto
import com.example.modanews.common.domain.repository.ICommonRepository

class CommonRepositoryImpl : ICommonRepository {
    override suspend fun getArticle(articleId: String): ArticleDto {
        TODO("Not yet implemented")
    }

    override suspend fun getArticles(): List<ArticleDto> {
        TODO("not yet implemented")
    }

    override suspend fun getUser(userId: String): UserDto {
        TODO("Not yet implemented")
    }
}