package com.app_matriculas.model

import androidx.room.Dao
import androidx.room.Insert
import com.app_matriculas.entities.UnitStudentCrossRef

@Dao
interface UnitStudentDao {
    @Insert
    suspend fun insert(unitStudentCrossRef: UnitStudentCrossRef)
}