package com.example.modanews.common.data_source.repository

import com.example.modanews.common.data_source.local.CommonDao
import com.example.modanews.common.data_source.remote.ArticleDto
import com.example.modanews.common.data_source.remote.RubricDto
import com.example.modanews.common.data_source.remote.api.CommonApi
import com.example.modanews.common.domain.model.Article
import com.example.modanews.common.domain.model.Bloc
import com.example.modanews.common.domain.model.Image
import com.example.modanews.common.domain.model.Link
import com.example.modanews.common.domain.model.LinkBloc
import com.example.modanews.common.domain.model.Rubric
import com.example.modanews.common.domain.model.User
import com.example.modanews.common.domain.repository.ICommonRepository
import com.example.modanews.feature_admin.data.data_source.remote.AuthorDto
import com.example.modanews.feature_admin.domain.model.Author
import com.example.modanews.feature_news.domain.model.Comment
import kotlinx.coroutines.flow.Flow

class CommonRepositoryImpl(
    private val dao: CommonDao,
    private val api: CommonApi
) : ICommonRepository {
    override suspend fun getArticle(articleId: String): Article {
        return dao.getArticle(articleId)
    }

    override suspend fun getArticles(): Flow<List<Article>> {
        return dao.getArticles()
    }

    override suspend fun getUser(userId: String): User {
        return dao.getUser(userId)
    }

    /**
     * Calls the Dao method that saves data in the local database
     *
     * @param article the article to be saved
     * @param comments the comments to be saved
     * @param links the links to be saved
     * @param blocs the blocs to be saved
     * @param images the images to be saved
     * @param blocLinks the blocLinks to be saved
     * @param rubrics the rubrics to be saved
     * @param authors the authors to be saved
     * @throws Exception if the api calls throw any exception
     * or if we were not able to insert data in the local database
     */
    @Throws(Exception::class)
    override suspend fun saveData(
        article: Article,
        comments: List<Comment>,
        links: List<Link>,
        blocs: List<Bloc>,
        images: MutableList<Image>,
        blocLinks: MutableList<LinkBloc>,
        rubrics: List<Rubric>,
        authors: List<Author>
    ) {
        dao.addData(article, comments, links, blocs, images, blocLinks, rubrics, authors)
    }

    override suspend fun getArticlesFromRemote(): List<ArticleDto> = api.getArticles()


    override suspend fun getRubricsFromRemote(): List<RubricDto> = api.getRubrics()

    override suspend fun getAuthorsFromRemote(): List<AuthorDto> = api.getAuthors()
}
