package com.example.modanews.feature_admin.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.modanews.common.domain.model.Article

@Dao
interface AdminDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setArticle(article: Article)
}
