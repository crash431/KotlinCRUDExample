package com.crash.se.Kotlin.Crud.Example.task

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.MockitoAnnotations
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
class TaskIntegrationTests(@Autowired val mockMvc: MockMvc, @Autowired val taskRepository: TaskRepository) {

    @BeforeEach
    fun beforeEach() {
        MockitoAnnotations.openMocks(this)
        taskRepository.deleteAll()
    }

    @AfterEach
    fun afterEach() {
        taskRepository.deleteAll()
    }

    @Test
    fun `when api is called with task, should return task with 201`() {
        val expected = """{"id":"1","title":"test","description":"","priority":"Low"}"""
        val task = Task("1", "test", "", "Low")

        mockMvc.perform(
            MockMvcRequestBuilders.post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(expected)
        )
            .andExpect(status().isCreated)
            .andExpect(content().string(expected))

        Assertions.assertEquals(taskRepository.findById("1").get(), task)
    }

    @Test
    fun `getTasks is called, should return 200 with list of tasks`() {
        val tasks = """[{"id":"1","title":"test","description":"","priority":"Low"}]"""
        val task = Task("1", "test", "", "Low")

        taskRepository.save(task)

        mockMvc.perform(
            MockMvcRequestBuilders.get("/tasks")
        )
            .andExpect(status().is2xxSuccessful)
            .andExpect(content().string(tasks))
    }
}