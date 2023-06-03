package com.app_matriculas.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UnitWithStudents(
    @Embedded val unitEntity: UnitEntity,
    @Relation(
        parentColumn = "unitId",
        entityColumn = "studentId",
        associateBy = Junction(UnitStudentCrossRef::class)
    )
    val studentEntities: List<StudentEntity>
)
