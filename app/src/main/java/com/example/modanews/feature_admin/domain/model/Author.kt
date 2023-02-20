package com.example.modanews.feature_admin.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Author (
    @PrimaryKey val authorId: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val dateOfBirth: Date
)
