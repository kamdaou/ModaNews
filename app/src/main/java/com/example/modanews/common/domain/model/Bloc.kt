package com.example.modanews.common.domain.model

import androidx.room.ColumnInfo
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
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Bloc(
    @PrimaryKey val blocId: String,
    val content: String,
    val subtitle: String,
    @ColumnInfo(index = true)
    val articleId: String
)
