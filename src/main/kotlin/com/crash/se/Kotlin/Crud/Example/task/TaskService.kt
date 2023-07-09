package com.crash.se.Kotlin.Crud.Example.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService {

    @Autowired
    private lateinit var taskRepository: TaskRepository

    fun createTask(task: Task): Task {
        taskRepository.save(task)
        return task
    }
}