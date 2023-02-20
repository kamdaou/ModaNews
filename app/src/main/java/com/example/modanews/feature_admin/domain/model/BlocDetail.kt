package com.example.modanews.feature_admin.domain.model

data class BlocDetail(
    val content: String,
    val subtitle: String,
    val articleId: String,
    val links: List<Link>
)
