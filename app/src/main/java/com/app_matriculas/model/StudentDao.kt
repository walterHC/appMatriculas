package com.app_matriculas.model

import androidx.room.*
import com.app_matriculas.entities.StudentEntity
import com.app_matriculas.entities.StudentWithBooks

@Dao
interface StudentDao {
    @Query("select * from student")
    suspend fun getAll(): List<StudentEntity>

    @Transaction
    @Query("select * from student")
    suspend fun getStudentWithBooks(): List<StudentWithBooks>

    @Insert
    suspend fun insert(studentEntity: StudentEntity)

    @Insert
    suspend fun insert(studentsEntity: List<StudentEntity>)

    @Delete
    suspend fun delete(studentEntity: StudentEntity)
}