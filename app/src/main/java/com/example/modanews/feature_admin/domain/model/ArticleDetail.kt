package com.example.modanews.feature_admin.domain.model

import com.example.modanews.feature_admin.data.data_source.remote.Comment
import java.util.Date

/**
 * We will put all the data retrieved from the databse into this
 * data class to allow us to easily create a UI that contains
 * the detailed article.
 */
data class ArticleDetail(
    val id: String,
    val title: String,
    val header: String,
    val blocs: List<BlocDetail>,
    val author: Author,
    val publicationDate: Date,
    val rubric: Rubric,
    val likes: List<ArticleLike>,
    val comments: List<Comment>,
)
