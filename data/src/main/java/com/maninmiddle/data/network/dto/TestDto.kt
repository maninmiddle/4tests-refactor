package com.maninmiddle.data.network.dto

import com.squareup.moshi.Json

data class TestDto(
    @field:Json(name = "name") var name: String,
    @field:Json(name = "subject") var subject: String,
    @field:Json(name = "completeTime") var completeTime: Int,
    @field:Json(name = "password") var password: String,
    @field:Json(name = "tasks") var tasks: MutableList<TaskDto>
)
