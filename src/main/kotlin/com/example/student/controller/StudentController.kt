package com.example.student.controller

import com.example.student.model.Student
import com.example.student.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class StudentController(
    @Autowired
    val studentService: StudentService
) {
    @GetMapping("/students")
    fun getAllStudents(): Flux<Student>{
        return studentService.findAllStudents()
    }

    @PostMapping("/students")
    fun addStudent(@RequestBody student:Student): Mono<Student>{
        return studentService.createStudent(student)
    }
    
    @GetMapping("/student/{id}")
    fun getStudent(@PathVariable id:String) :Mono<Student>{
        return studentService.findStudent(id)
    }
    
}