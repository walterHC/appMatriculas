package com.app_matriculas.entities

import androidx.room.Entity

@Entity(primaryKeys = ["unitId", "studentId"])
data class UnitStudentCrossRef(
    val unitId: Int,
    val studentId: Int
)
