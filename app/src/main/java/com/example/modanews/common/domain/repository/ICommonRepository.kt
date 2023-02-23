package com.example.modanews.common.domain.repository

import com.example.modanews.common.data_source.remote.ArticleDto
import com.example.modanews.common.data_source.remote.RubricDto
import com.example.modanews.common.domain.model.Article
import com.example.modanews.common.domain.model.Bloc
import com.example.modanews.common.domain.model.Image
import com.example.modanews.common.domain.model.Link
import com.example.modanews.common.domain.model.LinkBloc
import com.example.modanews.common.domain.model.Rubric
import com.example.modanews.common.domain.model.User
import com.example.modanews.feature_admin.data.data_source.remote.AuthorDto
import com.example.modanews.feature_admin.domain.model.Author
import com.example.modanews.feature_news.domain.model.Comment
import kotlinx.coroutines.flow.Flow

interface ICommonRepository {
    suspend fun getArticle(articleId: String): Article

    suspend fun getArticles(): Flow<List<Article>>

    suspend fun getUser(userId: String): User

    suspend fun saveData(
        article: Article,
        comments: List<Comment>,
        links: List<Link>,
        blocs: List<Bloc>,
        images: MutableList<Image>,
        blocLinks: MutableList<LinkBloc>,
        rubrics: List<Rubric>,
        authors: List<Author>
    )

    suspend fun getArticlesFromRemote(): List<ArticleDto>

    suspend fun getRubricsFromRemote(): List<RubricDto>

    suspend fun getAuthorsFromRemote(): List<AuthorDto>
}