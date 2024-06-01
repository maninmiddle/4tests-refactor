package com.maninmiddle.data.network

import com.maninmiddle.data.network.dto.TaskDto
import com.maninmiddle.data.network.dto.TestDto
import com.maninmiddle.data.network.dto.VariantDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/getTests")
    suspend fun getTests(): List<TestDto>

    @GET("/getTasks")
    suspend fun getTasks(@Query("testId") testId: Int): List<TaskDto>

    @GET("/getVariants")
    suspend fun getVariants(@Query("taskId") taskId: Int): List<VariantDto>
}