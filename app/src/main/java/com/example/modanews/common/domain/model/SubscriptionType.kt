package com.example.modanews.common.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SubscriptionType (
    @PrimaryKey
    val subscriptionTypeId: String,
    val description: String,
    val price: Float
)
