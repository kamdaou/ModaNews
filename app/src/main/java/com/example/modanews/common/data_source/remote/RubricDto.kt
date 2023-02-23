package com.example.modanews.common.data_source.remote

import com.example.modanews.common.domain.model.Rubric

data class RubricDto (
    val rubricId: String,
    val wording: String,
) {
    fun toRubric(): Rubric = Rubric(
        rubricId, wording
    )
}
