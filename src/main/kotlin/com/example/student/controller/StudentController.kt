package com.example.student.controller

import com.example.student.model.Student
import com.example.student.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class StudentController(
    @Autowired
    val studentService: StudentService
) {
    @GetMapping("/allStudnets")
    fun getAllStudents(): Flux<Student>{
        return studentService.findAllStudents()
    }
}