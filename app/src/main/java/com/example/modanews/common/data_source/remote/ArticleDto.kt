package com.example.modanews.common.data_source.remote

import com.example.modanews.feature_admin.data.data_source.remote.AuthorDto
import com.example.modanews.feature_news.data.data_source.remote.ArticleLikeDto
import com.example.modanews.feature_news.data.data_source.remote.CommentDto
import java.util.Date

data class ArticleDto(
    val articleId: String? = null,
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
