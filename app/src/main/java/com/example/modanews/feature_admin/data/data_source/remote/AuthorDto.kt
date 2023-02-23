package com.example.modanews.feature_admin.data.data_source.remote

import com.example.modanews.feature_admin.domain.model.Author
import java.util.Date

data class AuthorDto (
    val authorId: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val dateOfBirth: Date
) {
    fun toAuthor(): Author {
        return Author(
            authorId,
            firstName,
            lastName,
            email,
            dateOfBirth
        )
    }
}
