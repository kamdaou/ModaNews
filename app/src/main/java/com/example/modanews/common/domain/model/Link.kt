package com.example.modanews.common.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Link(
    @PrimaryKey val linkId: String,
    val wording: String,
    val isExternal: Boolean
)
