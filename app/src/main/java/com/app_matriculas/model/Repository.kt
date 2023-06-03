package com.app_matriculas.model

import com.app_matriculas.entities.*


class Repository(private val appDatabase: AppDatabase) {

    suspend fun getAllStudents(): List<StudentEntity> {
        return appDatabase.studentDao().getAll()
    }

    suspend fun getStudentWithBooks(): List<StudentWithBooks> {
        return appDatabase.studentDao().getStudentWithBooks()
    }

    suspend fun insertStudents(studentsEntity: List<StudentEntity>) {
        appDatabase.studentDao().insert(studentsEntity)
    }

    suspend fun insertBooks(books: List<BookEntity>) {
        appDatabase.bookDao().insert(books)
    }

    suspend fun insertBook(book: BookEntity) {
        appDatabase.bookDao().insert(book)
    }

    suspend fun getAllBooks(): List<BookEntity> {
        return appDatabase.bookDao().getAll()
    }

    suspend fun insertUnits(unitsEntity: List<UnitEntity>) {
        appDatabase.unitDao().insert(unitsEntity)
    }

    suspend fun getUnitWithStudents(): List<UnitWithStudents> {
        return appDatabase.unitDao().getUnitWithStudents()
    }

    suspend fun insertUnitStudents(unitStudentCrossRef: UnitStudentCrossRef) {
        appDatabase.unitStudentDao().insert(unitStudentCrossRef)
    }

}