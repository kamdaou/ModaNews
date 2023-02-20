package com.example.modanews.feature_news.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.modanews.common.domain.model.User
import com.example.modanews.feature_news.domain.model.ArticleLike
import com.example.modanews.feature_news.domain.model.Comment
import com.example.modanews.feature_news.domain.model.CommentLike
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM comment")
    fun getComments(): Flow<List<Comment>>

    @Query("SELECT * FROM user WHERE userId = :userId")
    suspend fun getUser(userId: String): User

    @Query("SELECT * FROM comment where commentId = :commentId")
    suspend fun getComment(commentId: String): Comment

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addComment(comment: Comment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCommentLike(commentLike: CommentLike)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticleLike(articleLike: ArticleLike)
}