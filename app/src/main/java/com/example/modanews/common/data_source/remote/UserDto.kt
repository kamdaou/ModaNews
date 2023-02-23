package com.example.modanews.common.data_source.remote

import java.util.Date

data class UserDto (
    val userId: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val dateOfBirth: Date,
    val subscription: SubscriptionDto
)
