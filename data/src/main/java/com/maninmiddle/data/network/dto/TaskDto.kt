package com.maninmiddle.data.network.dto

import com.squareup.moshi.Json

data class TaskDto(
    @field:Json(name = "text") var text: String,
    @field:Json(name = "variants") var variants: MutableList<String>,
    @field:Json(name = "rightVariants") var rightVariants: MutableList<Int>
)
