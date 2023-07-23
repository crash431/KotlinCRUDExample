package com.crash.se.Kotlin.Crud.Example.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/tasks")
class TaskController {

    @Autowired
    private lateinit var taskService: TaskService

    @GetMapping("/health")
    fun health(): String {
        return "API is healthy!"
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTask(@RequestBody task: Task): Task {
        return taskService.createTask(task)
    }

    @GetMapping
    fun getTasks(): List<Task> {
        return taskService.getTasks()
    }
}