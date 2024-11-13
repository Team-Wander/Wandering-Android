package com.wanderring.domain.model.enumType

enum class Grade(
    val description: String,
    val descriptionWithHash: String,
) {
    ONE(description = "1학년", descriptionWithHash = "#1학년"),
    TWO(description = "2학년", descriptionWithHash = "#2학년"),
    THREE(description = "3학년", descriptionWithHash = "#3학년"),
    FOUR(description = "4학년", descriptionWithHash = "#4학년"),
    FIVE(description = "5학년", descriptionWithHash = "#5학년"),
    SIX(description = "6학년", descriptionWithHash = "#6학년"),
    ALL(description = "전학년", descriptionWithHash = "#전학년"),
    NONE(description = "", descriptionWithHash = ""),
}