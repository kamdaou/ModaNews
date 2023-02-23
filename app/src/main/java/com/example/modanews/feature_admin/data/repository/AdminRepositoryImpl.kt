package com.example.modanews.feature_admin.data.repository

import com.example.modanews.common.data_source.remote.ArticleDto
import com.example.modanews.common.domain.model.Article
import com.example.modanews.feature_admin.data.data_source.local.AdminDao
import com.example.modanews.feature_admin.domain.repository.IAdminRepository

class AdminRepositoryImpl(private val dao: AdminDao) : IAdminRepository {

}