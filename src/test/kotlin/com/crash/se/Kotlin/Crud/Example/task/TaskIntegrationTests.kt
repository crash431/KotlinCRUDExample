package com.crash.se.Kotlin.Crud.Example.task

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class TaskIntegrationTests(@Autowired val mockMvc: MockMvc) {

    @Mock
    private lateinit var taskRepository: TaskRepository

    @AfterEach
    fun afterEach() {
        taskRepository.deleteAll()
    }

    @Test
    fun `when api is called with task, should return task with 201`() {
        val task = """{"id":"1","title":"test","description":"","priority":"Low"}"""

        mockMvc.perform(
            MockMvcRequestBuilders.post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(task)
        )
            .andExpect(status().isCreated)
            .andExpect(content().string(task))
    }
}