package com.example.modanews.feature_admin.domain.model

import com.example.modanews.common.domain.model.Link

data class BlocDetail(
    val content: String,
    val subtitle: String,
    val articleId: String,
    val links: List<Link>
)
