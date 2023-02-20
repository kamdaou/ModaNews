package com.example.modanews.common.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rubric (
    @PrimaryKey
    val rubricId: String,
    val wording: String
)
