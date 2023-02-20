package com.example.modanews.feature_admin.data.data_source.remote

import org.w3c.dom.Text

data class BlocDto (
    val blocId: String,
    val content: Text,
    val img: List<String>,
    val subtitle: String,
)
