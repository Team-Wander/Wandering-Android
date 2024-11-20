package com.wanderring.domain.model.model.address

data class AddressModel(
    val juso: List<JusoModel>
)

data class JusoModel(
    val roadAddr: String,
    val jibunAddr: String,
)
