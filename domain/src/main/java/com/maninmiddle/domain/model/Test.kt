package com.maninmiddle.domain.model

data class Test(
    var name: String,
    var subject: String,
    var completeTime: Int,
    var password: String,
    var tasks: MutableList<Task>
) {
    val id: Int = -1
    var isAnimated: Boolean = false
}

fun Test.isDefault(): Boolean {
    return name.isEmpty() && subject.isEmpty() && completeTime == 0 && password.isEmpty() && tasks.isEmpty()
}
