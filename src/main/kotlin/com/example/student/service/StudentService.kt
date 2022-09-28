package com.example.student.service

import com.example.student.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService(
    @Autowired
    val studentRepository: StudentRepository
) {

    
}