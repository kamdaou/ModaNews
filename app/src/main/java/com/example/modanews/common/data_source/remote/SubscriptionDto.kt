package com.example.modanews.common.data_source.remote

import com.google.type.Date


data class SubscriptionDto(
    val subscriptionId: String? = null,
    val totalPrice: Float,
    val startingDate: Date,
    val endingDate: Date,
    val subscriptionTypes: List<SubscriptionTypeDto>
)
