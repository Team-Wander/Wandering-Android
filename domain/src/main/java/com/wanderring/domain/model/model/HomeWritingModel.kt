package com.wanderring.domain.model.model

import com.wanderring.domain.model.enumType.Tag

data class HomeWritingModel(
    val id: Long,
    val author: String,
    val title: String,
    val content: String,
    val date: String,
    val maximum: Int,
    val tag: Tag,
)