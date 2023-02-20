package com.example.modanews.feature_admin.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Date

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
    val subscriptionId: String,
)
