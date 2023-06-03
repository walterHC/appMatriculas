package com.app_matriculas.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class BookEntity (
    @PrimaryKey(autoGenerate = true)
    val bookId:Int,
    val name:String,
    val studentOwnerId:Int
)
{
    constructor(name: String,studentId: Int) : this(0, name,studentId)
}
