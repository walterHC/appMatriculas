package com.app_matriculas.entities

import androidx.room.Embedded
import androidx.room.Relation

data class StudentWithBooks(
    @Embedded val studentEntity: StudentEntity,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "studentOwnerId"
    )
    val books: List<BookEntity>

)
