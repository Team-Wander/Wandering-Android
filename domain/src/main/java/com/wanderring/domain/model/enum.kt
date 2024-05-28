package com.wanderring.domain.model


enum class Tag(
    val description: String,
    val colorCode: Long,
) {
    WALK(description = "산책", colorCode = 0xFFFF6868),
    WORRY(description = "고민", colorCode = 0xFFF5C185),
    CHAT(description = "잡담", colorCode = 0xFF36C05C),
    EXERCISE(description = "외출", colorCode = 0xFF7CAAEF),
    STUDY(description = "운동", colorCode = 0xFF9A7CEF),
    GO_OUT(description = "공부", colorCode = 0xFF868686),
    NONE(description = "", colorCode = 0);
}