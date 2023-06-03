package com.app_matriculas.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app_matriculas.entities.BookEntity

@Dao
interface BookDao {
    @Query("select * from book")
    suspend fun getAll(): List<BookEntity>

    @Insert
    suspend fun insert(bookEntity: BookEntity)

    @Insert
    suspend fun insert(booksEntity: List<BookEntity>)

    @Delete
    suspend fun delete(bookEntity: BookEntity)
}