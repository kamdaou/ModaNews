package com.example.modanews.common.data_source.remote

import com.example.modanews.common.domain.model.Image

data class ImageDto(
    val imageId: String,
    val url: String
) {
    fun toImage(blocId: String): Image {
        return Image(
            imageId,
            url,
            blocId
        )
    }
}
