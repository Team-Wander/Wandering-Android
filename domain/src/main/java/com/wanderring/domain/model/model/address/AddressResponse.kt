package com.wanderring.domain.model.model.address
data class AddressResponse(
    val results: Results
)

data class Results(
    val common: Common,
    val juso: List<Juso>
)

data class Common(
    val totalCount: String,
    val errorMessage: String,
    val errorCode: String
)

data class Juso(
    val roadAddr: String,
    val jibunAddr: String,
    val zipNo: String
)
