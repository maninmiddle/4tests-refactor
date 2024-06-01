package com.maninmiddle.domain.repository

import com.maninmiddle.domain.model.Task
import com.maninmiddle.domain.model.Test
import com.maninmiddle.domain.model.Variant
import com.maninmiddle.domain.util.ApiState

interface TestsRepository {
    suspend fun getTests(): ApiState<List<Test>>
    suspend fun getTasks(testId: Int): ApiState<List<Task>>
    suspend fun getVariants(taskId: Int): ApiState<List<Variant>>
}