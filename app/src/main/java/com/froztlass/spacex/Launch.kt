package com.froztlass.spacex

//10121079
//Fa'i Refriandi
//IF-2 (PemAndro-3)

data class Launch(
    val mission_name: String,
    val launch_year: String,
    val rocket: Rocket,
    val details: String?,
    val links: Links
) {
    val nationality: String?
        get() = rocket.second_stage.payloads.firstOrNull()?.nationality
}
data class Rocket(
    val rocket_name: String,
    val rocket_type: String,
    val second_stage: SecondStage
)
data class SecondStage(
    val payloads: List<Payload>
)
data class Payload(
    val payload_id: String,
    val nationality: String?
)
data class Links(
    val mission_patch: String?
)
