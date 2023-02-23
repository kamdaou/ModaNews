package com.example.modanews.common.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.modanews.common.data_source.remote.ArticleDto
import com.example.modanews.common.domain.model.Article
import com.example.modanews.common.domain.model.Bloc
import com.example.modanews.common.domain.model.Image
import com.example.modanews.common.domain.model.Link
import com.example.modanews.common.domain.model.LinkBloc
import com.example.modanews.common.domain.model.Rubric
import com.example.modanews.common.domain.model.User
import com.example.modanews.feature_admin.domain.model.Author
import com.example.modanews.feature_news.domain.model.ArticleLike
import com.example.modanews.feature_news.domain.model.Comment
import com.example.modanews.feature_news.domain.model.CommentLike
import kotlinx.coroutines.flow.Flow

@Dao
interface CommonDao {
    @Query("SELECT * FROM article WHERE articleId = :articleId")
    suspend fun getArticle(articleId: String): Article

    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<Article>>

    @Query("SELECT * FROM user WHERE userId = :userId")
    suspend fun getUser(userId: String): User


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArticle(article: Article)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addAuthors(authors: List<Author>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addComments(comments: List<Comment>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCommentLike(commentLike: CommentLike)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticleLike(articleLike: ArticleLike)

    @Query("SELECT * FROM rubric WHERE rubricId = :rubricId")
    suspend fun doesRubricExist(rubricId: String): Rubric?

    @Query("SELECT * FROM author WHERE authorId = :authorId")
    suspend fun doesAuthorExist(authorId: String): Author?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addRubrics(rubrics: List<Rubric>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBloc(bloc: Bloc)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBlocs(bloc: List<Bloc>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLink(link: Link)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLinks(link: List<Link>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLinkBlocs(linkBloc: List<LinkBloc>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImage(image: Image)

    @Transaction
    suspend fun insertBlocsAndLinks(blocs: List<Bloc>, links: List<Link>, articleDto: ArticleDto) {
        addBlocs(blocs)
        addLinks(links)

    }

    /**
     * Saves data in the local database using transactions to avoid
     * exceptions that may come from foreign key constraints
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
     */
    @Transaction
    suspend fun addData(
        article: Article,
        comments: List<Comment>,
        links: List<Link>,
        blocs: List<Bloc>,
        images: List<Image>,
        blocLinks: List<LinkBloc>,
        rubrics: List<Rubric>,
        authors: List<Author>
    ) {
        addRubrics(rubrics)
        addAuthors(authors)
        addArticle(article)
        addComments(comments)
        addBlocs(blocs)
        addLinks(links)
        addLinkBlocs(blocLinks)
    }
}
