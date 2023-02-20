package com.example.modanews.common.data_source.remote

import org.w3c.dom.Text

data class BlocDto (
    val blocId: String? = null,
    val content: Text,
    val img: List<String>,
    val subtitle: String,
)
