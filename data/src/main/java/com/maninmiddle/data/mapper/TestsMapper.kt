package com.maninmiddle.data.mapper

import com.maninmiddle.data.network.dto.TaskDto
import com.maninmiddle.data.network.dto.TestDto
import com.maninmiddle.data.network.dto.VariantDto
import com.maninmiddle.domain.model.Task
import com.maninmiddle.domain.model.Test
import com.maninmiddle.domain.model.Variant


fun List<TaskDto>.toMutableTaskList(): MutableList<Task> {
    return this.map { taskDto ->
        Task(
            text = taskDto.text,
            variants = taskDto.variants,
            rightVariants = taskDto.rightVariants
        )
    }.toMutableList()
}

fun List<TestDto>.toTestsList(): List<Test> {
    return this.map { testDto ->
        Test(
            name = testDto.name,
            subject = testDto.subject,
            completeTime = testDto.completeTime,
            password = testDto.password,
            tasks = testDto.tasks.toMutableTaskList()
        )
    }
}

fun List<TaskDto>.toTasksList(): List<Task> {
    return this.map { taskDto ->
        Task(
            text = taskDto.text,
            variants = taskDto.variants,
            rightVariants = taskDto.rightVariants
        )
    }
}

fun List<VariantDto>.toVariantsList(): List<Variant> {
    return this.map { variantDto ->
        Variant(
            taskId = variantDto.taskId,
            text = variantDto.text,
            isRight = variantDto.isRight
        )
    }
}