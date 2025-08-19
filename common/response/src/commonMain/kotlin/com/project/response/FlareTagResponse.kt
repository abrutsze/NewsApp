package com.project.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlareTagResponse(
    @SerialName("bg_color_hex")
    val bgColorHex: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("text_color_hex")
    val textColorHex: String?
)