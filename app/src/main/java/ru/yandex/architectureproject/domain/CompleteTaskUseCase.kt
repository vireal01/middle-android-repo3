package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.data.repository.TaskRepository

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    private val delayTime = 10_000L

    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        delay(delayTime)
        repository.deleteTask(taskId)
    }
}
