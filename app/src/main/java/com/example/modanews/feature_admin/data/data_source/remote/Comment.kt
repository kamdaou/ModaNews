package com.example.modanews.feature_admin.data.data_source.remote

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.modanews.feature_admin.domain.model.Article

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Article::class,
            parentColumns = arrayOf("articleId"),
            childColumns = arrayOf("articleId")
        )
    ]
)
data class Comment(
    @PrimaryKey val commentId: String,
    val content: String,
    val articleId: String
)
