package com.wanderring.domain.model.enumType

enum class Tag(val description: String, ) {
    WALK(description = "산책"),
    WORRY(description = "고민"),
    CHAT(description = "잡담"),
    EXERCISE(description = "외출"),
    STUDY(description = "운동"),
    GO_OUT(description = "공부"),
    NONE(description = "");
}