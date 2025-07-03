package com.sybylle.azalea.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Collection<T>(
    @SerialName("result")
    val result: String,
    @SerialName("data")
    val data: List<T>,
)