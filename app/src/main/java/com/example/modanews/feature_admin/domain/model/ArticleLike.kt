package com.example.modanews.feature_admin.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Article::class,
            parentColumns = arrayOf("articleId"),
            childColumns = arrayOf("articleId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("userId"),
            childColumns = arrayOf("userId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
    ]
)
data class ArticleLike(
    @PrimaryKey val articleLikeId: String,
    val score: Boolean,
    val articleId: String,
    val userId: String
)