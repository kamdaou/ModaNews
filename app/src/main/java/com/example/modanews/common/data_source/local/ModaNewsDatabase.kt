package com.example.modanews.common.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.modanews.common.domain.model.Article
import com.example.modanews.common.domain.model.Bloc
import com.example.modanews.common.domain.model.Image
import com.example.modanews.common.domain.model.Link
import com.example.modanews.common.domain.model.Rubric
import com.example.modanews.common.domain.model.Subscription
import com.example.modanews.common.domain.model.SubscriptionType
import com.example.modanews.common.domain.model.User
import com.example.modanews.feature_admin.data.data_source.local.AdminDao
import com.example.modanews.feature_admin.domain.model.Author
import com.example.modanews.feature_news.data.data_source.local.NewsDao
import com.example.modanews.feature_news.domain.model.ArticleLike
import com.example.modanews.feature_news.domain.model.Comment
import com.example.modanews.feature_news.domain.model.CommentLike
import com.example.modanews.utils.DateConverter

@Database(
    entities = [
        Article::class,
        Subscription::class,
        Rubric::class,
        Author::class,
        CommentLike::class,
        ArticleLike::class,
        Link::class,
        Image::class,
        Bloc::class,
        SubscriptionType::class,
        Comment::class,
        User::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class ModaNewsDatabase: RoomDatabase() {
    abstract val commonDao: CommonDao
    abstract val adminDao: AdminDao
    abstract val newsDao: NewsDao

    companion object {
        const val DATABASE_NAME = "moda_news_db"
    }
}