package com.example.modanews.feature_admin.data.data_source.remote

import java.util.Date

data class ArticleDto(
    val articleId: String,
    val title: String,
    val header: String,
    val blocs: List<BlocDto>,
    val author: AuthorDto,
    val publicationDate: Date,
    val rubric: RubricDto,
    val likes: List<ArticleLikeDto>,
    val comments: List<CommentDto>,
    val links: List<String>
)
