package com.example.modanews.common.data_source.remote

import com.example.modanews.common.domain.model.Link

data class BlocDto (
    val blocId: String,
    val content: String,
    val img: List<ImageDto>,
    val subtitle: String,
    val links: List<LinkDto>
) {
    fun toLinks(): List<Link> = links.map {
        Link(
            linkId = it.linkId,
            wording = it.wording,
            isExternal = it.isExternal
        )
    }
}
