package com.crash.se.Kotlin.Crud.Example.task

import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.kotlin.any
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig
class TaskControllerTests {

    @Mock
    private lateinit var taskService: TaskService
    @InjectMocks
    private lateinit var taskController: TaskController

    @Test
    fun `test createTask should call service with the correct parameters`() {
        val task = Task("1", "Test", "", "Low")
        Mockito.`when`(taskService.createTask(task)).thenReturn(any())
        taskController.createTask(task)

        verify(taskService).createTask(task)
    }
}