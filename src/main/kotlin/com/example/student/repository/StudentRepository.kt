package com.example.student.repository

import com.example.student.model.Student
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface StudentRepository : ReactiveMongoRepository<Student, String>{
}