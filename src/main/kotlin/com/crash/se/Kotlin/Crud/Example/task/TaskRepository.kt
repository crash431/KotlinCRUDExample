package com.crash.se.Kotlin.Crud.Example.task

import org.springframework.data.mongodb.repository.MongoRepository

interface TaskRepository: MongoRepository<Task, String>