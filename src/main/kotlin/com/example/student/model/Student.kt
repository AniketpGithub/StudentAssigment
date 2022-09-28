package com.example.student.model

import org.springframework.data.annotation.Id

data class Student(
    @Id
    val id : String?,
    val studentName: String?,
    val rollNo: Int?,
    val address: String?

) {
}