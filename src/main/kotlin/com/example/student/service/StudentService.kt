package com.example.student.service

import com.example.student.model.Student
import com.example.student.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class StudentService(
    @Autowired
    val studentRepository: StudentRepository
) {

   fun findAllStudents(): Flux<Student>{
       return studentRepository.findAll()
   }
}