package com.example.modanews.common.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.modanews.feature_admin.domain.model.Author
import java.util.Date

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Rubric::class,
            parentColumns = arrayOf("rubricId"),
            childColumns = arrayOf("rubricId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = Author::class,
            parentColumns = arrayOf("authorId"),
            childColumns = arrayOf("authorId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
    ]
)
data class Article(
    @PrimaryKey
    val articleId: String,
    val title: String,
    val header: String,
    val publicationDate: Date,
    @ColumnInfo(index = true)
    val authorId: String,
    @ColumnInfo(index = true)
    val rubricId: String,
)
