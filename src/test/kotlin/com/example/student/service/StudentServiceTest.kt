package com.example.student.service

import com.example.student.model.Student
import com.example.student.repository.StudentRepository
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


class StudentServiceTest{

    val student1 = Student("101","Aniket",1,"Mumbai")
    val student2 = Student("102","Rohit",2,"Pune")



    private val studentRepository = mockk<StudentRepository>(){
        every{
            findAll()
        }returns Flux.just(student1,student2)

        every{
            findById("2")
        }returns Mono.just(student2)




    }

    private  val studentService = StudentService(studentRepository)

    @Test
    fun `should return all students`()
    {
        val stud1 = studentService.findAllStudents().blockFirst()
        val stud2 = studentService.findAllStudents().blockLast()

        stud1 shouldBe student1
        stud2 shouldBe student2
    }

    @Test
    fun `should create student `(){


        every{
            studentRepository.save(student1)
        } returns Mono.just(student1)
        val addStudent = studentService.createStudent(student1).block()

        addStudent shouldBe student1

    }


    @Test
    fun `should update student info `(){


        every{
            studentRepository.save(student1)
        } returns Mono.just(student1)
        val updateStudent = studentService.updateStudentById("1",student1).block()

        updateStudent shouldBe student1

    }

    @Test
    fun `should delete student by Id `(){


        every{
            studentRepository.deleteById("1")
        } returns Mono.empty()

    }

}
