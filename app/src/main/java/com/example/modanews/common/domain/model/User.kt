package com.example.modanews.common.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Subscription::class,
            parentColumns = arrayOf("subscriptionId"),
            childColumns = arrayOf("subscriptionId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class User (
    @PrimaryKey
    val userId: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val dateOfBirth: Date,
    @ColumnInfo(index = true)
    val subscriptionId: String,
)
