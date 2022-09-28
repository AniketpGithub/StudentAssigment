package com.example.student.controller

import com.example.student.model.Student
import com.example.student.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
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

    @PutMapping("/student/{id}")
    fun updateById(@PathVariable id: String, @RequestBody student: Student): Mono<Student> {
        return studentService.updateStudentById(id,student)
    }

    @DeleteMapping("/student/{id}")
    fun deleteStudent(@PathVariable id: String): Mono<Void> {
        return studentService.deleteStudentById(id)
    }
}