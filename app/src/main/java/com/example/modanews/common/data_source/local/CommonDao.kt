package com.example.modanews.common.data_source.local

import androidx.room.Dao
import androidx.room.Query
import com.example.modanews.common.domain.model.Article
import com.example.modanews.common.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface CommonDao {
    @Query("SELECT * FROM article WHERE articleId = :articleId")
    suspend fun getArticle(articleId: String): Article

    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<Article>>

    @Query("SELECT * FROM user WHERE userId = :userId")
    suspend fun getUser(userId: String): User
}
