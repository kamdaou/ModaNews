package com.example.modanews.feature_admin.data.data_source.remote

import java.util.Date

data class AuthorDto (
    val authorId: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val dateOfBirth: Date
)
