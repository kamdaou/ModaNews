package com.example.modanews.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.modanews.common.data_source.local.ModaNewsDatabase
import com.example.modanews.common.data_source.remote.api.CommonApi
import com.example.modanews.common.data_source.remote.worker.RefreshDataWork
import com.example.modanews.common.data_source.repository.CommonRepositoryImpl
import com.example.modanews.common.domain.repository.ICommonRepository
import com.example.modanews.feature_admin.data.repository.AdminRepositoryImpl
import com.example.modanews.feature_admin.domain.repository.IAdminRepository
import com.example.modanews.feature_news.data.repository.NewsRepositoryImpl
import com.example.modanews.feature_news.domain.repository.INewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideModaNewsDatabase(application: Application): ModaNewsDatabase {
        return Room.databaseBuilder(
            application,
            ModaNewsDatabase::class.java,
            ModaNewsDatabase.DATABASE_NAME
        )
            .build()
    }

    @Provides
    fun provideCommonApi(): CommonApi {
        return CommonApi()
    }

    @Provides
    fun provideCommonRepository(database: ModaNewsDatabase, api: CommonApi): ICommonRepository {
        return CommonRepositoryImpl(database.commonDao, api)
    }

    @Provides
    fun provideNewsRepository(database: ModaNewsDatabase): INewsRepository {
        return NewsRepositoryImpl(database.newsDao)
    }

    @Provides
    fun provideAdminRepository(database: ModaNewsDatabase): IAdminRepository {
        return AdminRepositoryImpl(database.adminDao)
    }
}
