package com.example.modanews.common.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = SubscriptionType::class,
            parentColumns = arrayOf("subscriptionTypeId"),
            childColumns = arrayOf("subscriptionTypeId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Subscription (
    @PrimaryKey
    val subscriptionId: String,
    val totalPrice: Float,
    val startingDate: Date,
    val endingDate: Date,
    @ColumnInfo(index = true)
    val subscriptionTypeId: String
)
