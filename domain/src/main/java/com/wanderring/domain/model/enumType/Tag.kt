package com.wanderring.domain.model.enumType

enum class Tag(
    val description: String,
    val descriptionWithHash: String,
) {
    WALK(description = "산책", descriptionWithHash = "#산책"),
    WORRY(description = "고민", descriptionWithHash = "#고민"),
    CHAT(description = "잡담", descriptionWithHash = "#잡담"),
    STUDY(description = "운동", descriptionWithHash = "#운동"),
    GO_OUT(description = "공부", descriptionWithHash = "#공부"),
    EXERCISE(description = "외출", descriptionWithHash = "#외출"),
}