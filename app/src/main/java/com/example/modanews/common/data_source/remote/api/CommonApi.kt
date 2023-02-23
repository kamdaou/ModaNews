package com.example.modanews.common.data_source.remote.api

import com.example.modanews.common.data_source.remote.ArticleDto
import com.example.modanews.common.data_source.remote.RubricDto
import com.example.modanews.common.data_source.remote.UserDto
import com.example.modanews.feature_admin.data.data_source.remote.AuthorDto
import com.example.modanews.utils.Constants
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class CommonApi {
    val firestore = FirebaseFirestore.getInstance()

    /**
     * Retrieve an specific article from Firestore
     *
     * @param articleId the unique identifier of the article
     * @throws Exception if the specified article is not found or any other
     * @return the article data as a ArticleDto object
     */
    @Throws(Exception::class)
    suspend fun getArticle(articleId: String): ArticleDto? {
        val documents = firestore.collection(Constants.ARTICLE_NAME)
            .whereEqualTo("articleId", articleId)
            .get().await().documents
        var articleDto: ArticleDto? = null
        if (documents.isNotEmpty()) {
            articleDto = documents.first().toObject(ArticleDto::class.java)
        }
        return articleDto
    }

    /**
     * Retrieve articles from Firestore
     *
     * @throws Exception in case of any exception with Firebase
     * @return articles data as a List<ArticleDto> object
     */
    @Throws(Exception::class)
    suspend fun getArticles(): List<ArticleDto> {
        val articles = mutableListOf<ArticleDto>()
        val querySnapshot = firestore.collection(Constants.ARTICLE_NAME).get().await()

        for (document in querySnapshot.documents) {
            val article = document.toObject(ArticleDto::class.java)
            if (article != null) {
                articles.add(article)
            }
        }
        return articles
    }

    suspend fun getUser(userId: String): UserDto {
        TODO("Not yet implemented")
    }

    /**
     * Retrieve rubrics from Firestore
     *
     * @throws Exception in case of any exception with Firebase
     * @return articles data as a List<RubricDto> object
     */
    suspend fun getRubrics(): List<RubricDto> {
        val rubricsDto = mutableListOf<RubricDto>()
        val querySnapshot = firestore.collection(Constants.RUBRIC_NAME).get().await()

        for (document in querySnapshot.documents) {
            val authorDto = document.toObject(RubricDto::class.java)
            if (authorDto != null) {
                rubricsDto.add(authorDto)
            }
        }
        return rubricsDto
    }

    /**
     * Retrieve authors from Firestore
     *
     * @throws Exception in case of any exception with Firebase
     * @return authors data as a List<AuthorDto> object
     */
    @Throws(Exception::class)
    suspend fun getAuthors(): List<AuthorDto> {
        val authorsDto = mutableListOf<AuthorDto>()
        val querySnapshot = firestore.collection(Constants.AUTHOR_NAME).get().await()

        for (document in querySnapshot.documents) {
            val authorDto = document.toObject(AuthorDto::class.java)
            if (authorDto != null) {
                authorsDto.add(authorDto)
            }
        }
        return authorsDto
    }
}