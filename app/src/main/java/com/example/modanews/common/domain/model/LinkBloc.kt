package com.example.modanews.common.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    primaryKeys = [
        "blocId",
        "linkId"
    ],
    foreignKeys = [
        ForeignKey(
            entity = Bloc::class,
            parentColumns = arrayOf("blocId"),
            childColumns = arrayOf("blocId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Link::class,
            parentColumns = arrayOf("linkId"),
            childColumns = arrayOf("linkId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class LinkBloc(
    @ColumnInfo("blocId")
    val blocId: String,
    @ColumnInfo("linkId")
    val linkId: String
)
