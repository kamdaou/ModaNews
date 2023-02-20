package com.example.modanews.feature_news.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.modanews.common.domain.model.Article

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
    @ColumnInfo(index = true)
    val articleId: String
)
