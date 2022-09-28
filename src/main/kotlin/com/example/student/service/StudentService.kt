package com.example.student.service

import com.example.student.model.Student
import com.example.student.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class StudentService(
    @Autowired
    val studentRepository: StudentRepository
) {

   fun findAllStudents(): Flux<Student>{
       return studentRepository.findAll()
   }

    fun createStudent(student: Student): Mono<Student> {
        return studentRepository.save(student)
    }

    fun findStudent(id:String ): Mono<Student>{
        return studentRepository.findById(id)
    }

    fun updateStudentById(id:String, student: Student):Mono<Student>{
        return studentRepository.save(student)
    }

    fun deleteStudentById(id: String): Mono<Void>{
        return studentRepository.deleteById(id)

    }

}