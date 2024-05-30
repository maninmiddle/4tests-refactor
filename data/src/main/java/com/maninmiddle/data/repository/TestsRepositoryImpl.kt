package com.maninmiddle.data.repository

import com.maninmiddle.data.mapper.toTasksList
import com.maninmiddle.data.mapper.toTestsList
import com.maninmiddle.data.mapper.toVariantsList
import com.maninmiddle.data.network.ApiService
import com.maninmiddle.domain.model.Task
import com.maninmiddle.domain.model.Test
import com.maninmiddle.domain.model.Variant
import com.maninmiddle.domain.repository.TestsRepository
import com.maninmiddle.domain.util.ApiState
import javax.inject.Inject

class TestsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TestsRepository {
    override suspend fun getTests(): ApiState<List<Test>> {
        return try {
            ApiState.Success(
                data = apiService.getTests().toTestsList()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ApiState.Error(e.message ?: "An unknown error occurred")
        }
    }

    override suspend fun getTasks(testId: Int): ApiState<List<Task>> {
        return try {
            ApiState.Success(
                data = apiService.getTasks(testId).toTasksList()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ApiState.Error(e.message ?: "An unknown error occurred")
        }
    }

    override suspend fun getVariants(taskId: Int): ApiState<List<Variant>> {
        return try {
            ApiState.Success(
                data = apiService.getVariants(taskId).toVariantsList()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ApiState.Error(e.message ?: "An unknown error occurred")
        }
    }
}