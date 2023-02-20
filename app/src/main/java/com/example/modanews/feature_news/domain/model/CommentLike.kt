package com.example.modanews.feature_news.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.modanews.common.domain.model.User

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Comment::class,
            parentColumns = arrayOf("commentId"),
            childColumns = arrayOf("commentId"),
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
data class CommentLike(
    @PrimaryKey val commentLikeId: String,
    val score: Boolean,
    @ColumnInfo(index = true)
    val commentId: String,
    @ColumnInfo(index = true)
    val userId: String
)
