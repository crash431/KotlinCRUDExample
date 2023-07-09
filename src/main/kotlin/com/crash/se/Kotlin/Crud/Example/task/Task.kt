package com.crash.se.Kotlin.Crud.Example.task

import org.springframework.data.annotation.Id

data class Task(
        @Id
        val id: Int,
        val title: String,
        val description: String,
        val priority: String
)
