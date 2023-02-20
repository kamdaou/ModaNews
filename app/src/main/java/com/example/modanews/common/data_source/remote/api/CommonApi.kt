package com.example.modanews.common.data_source.remote.api

import com.example.modanews.common.data_source.remote.ArticleDto
import com.example.modanews.common.data_source.remote.UserDto
import com.google.firebase.firestore.FirebaseFirestore

class CommonApi {
    private val firestore = FirebaseFirestore.getInstance()

    suspend fun getArticle(articleId: String): ArticleDto {
        TODO()
    }
    suspend fun getArticles(): List<ArticleDto> {
        TODO("not yet implemented")
    }

    suspend fun getUser(userId: String): UserDto {
        TODO("Not yet implemented")
    }
}