package com.example.modanews.feature_admin.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.modanews.feature_admin.data.data_source.remote.Comment
import java.sql.Date

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
    val id: String? = null,
    val title: String,
    val header: String,
    val publicationDate: Date,
    val authorId: String,
    val rubricId: String,
)
