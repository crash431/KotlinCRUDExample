package com.crash.se.Kotlin.Crud.Example.task

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig
class TaskServiceTests {

    @InjectMocks
    private lateinit var taskService: TaskService
    @Mock
    private lateinit var taskRepository: TaskRepository

    @Test
    fun `can create task`() {
        val task = Task("1", "Test", "", "Low")
        Mockito.`when`(taskRepository.save(task)).thenReturn(task)
        val actual = taskService.createTask(task)
        verify(taskRepository).save(task)
        assertEquals(task, actual)
    }

    @Test
    fun `can get all tasks`() {
        val tasks = listOf<Task>(
            Task("1", "Test", "", "Low"),
            Task("2", "Test2", "", "High")
        )

        Mockito.`when`(taskRepository.findAll()).thenReturn(tasks)
        val actual = taskService.getTasks()
        verify(taskRepository).findAll()
        assertEquals(tasks, actual)
    }
}