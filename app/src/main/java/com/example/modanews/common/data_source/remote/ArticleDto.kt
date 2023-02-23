package com.example.modanews.common.data_source.remote

import com.example.modanews.common.domain.model.Article
import com.example.modanews.common.domain.model.Bloc
import com.example.modanews.common.domain.model.Link
import com.example.modanews.common.domain.model.Rubric
import com.example.modanews.feature_admin.data.data_source.remote.AuthorDto
import com.example.modanews.feature_admin.domain.model.Author
import com.example.modanews.feature_news.data.data_source.remote.ArticleLikeDto
import com.example.modanews.feature_news.data.data_source.remote.CommentDto
import com.example.modanews.feature_news.data.data_source.remote.CommentLikeDto
import com.example.modanews.feature_news.domain.model.ArticleLike
import com.example.modanews.feature_news.domain.model.Comment
import com.example.modanews.feature_news.domain.model.CommentLike
import java.util.Date

data class ArticleDto(
    val articleId: String,
    val title: String,
    val header: String,
    val blocs: List<BlocDto>,
    val author: AuthorDto,
    val publicationDate: Date,
    val rubric: RubricDto,
    val articleLikes: List<ArticleLikeDto>,
    val comments: List<CommentDto>,
) {
    fun toArticle(): Article {
        return Article(
            articleId = articleId,
            title = title,
            header = header,
            publicationDate = publicationDate,
            authorId = author.authorId,
            rubricId = rubric.rubricId
        )
    }

    fun toAuthor(): Author {
        return Author(
            authorId = author.authorId,
            firstName = author.firstName,
            lastName = author.lastName,
            email = author.email,
            dateOfBirth = author.dateOfBirth
        )
    }

    fun toArticleLikes(): List<ArticleLike> = articleLikes.map {
        ArticleLike(
            articleId = articleId,
            articleLikeId = it.likeId,
            score = it.score,
            userId = it.user.userId
        )
    }

    fun toBlocs(): List<Bloc> = blocs.map {
        Bloc(
            blocId = it.blocId,
            content = it.content,
            subtitle = it.subtitle,
            articleId = it.subtitle
        )
    }

    fun toComments(): List<Comment> = comments.map {
        Comment(
            it.commentId,
            it.content,
            it.articleId
        )
    }

    fun toRubric(): Rubric = Rubric(
        rubricId = rubric.rubricId,
        wording = rubric.wording
    )
}
