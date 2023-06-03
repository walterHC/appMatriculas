package com.app_matriculas.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.app_matriculas.entities.UnitEntity
import com.app_matriculas.entities.UnitWithStudents

@Dao
interface UnitDao {

    @Insert
    suspend fun insert(unitEntity: List<UnitEntity>)

    @Transaction
    @Query("SELECT * FROM unit")
    suspend fun getUnitWithStudents(): List<UnitWithStudents>

}