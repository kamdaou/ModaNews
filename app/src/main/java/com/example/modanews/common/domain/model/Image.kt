package com.example.modanews.common.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Bloc::class,
            parentColumns = arrayOf("blocId"),
            childColumns = arrayOf("blocId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Image(
    @PrimaryKey
    val imageId: String,

    val url: String,
    val blocId: String
)
