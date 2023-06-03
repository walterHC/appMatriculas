package com.app_matriculas.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app_matriculas.entities.BookEntity
import com.app_matriculas.entities.StudentEntity
import com.app_matriculas.entities.UnitEntity
import com.app_matriculas.entities.UnitStudentCrossRef

@Database(
    entities = [StudentEntity::class, BookEntity::class, UnitEntity::class, UnitStudentCrossRef::class],
    version = 4
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun bookDao(): BookDao
    abstract fun unitDao(): UnitDao
    abstract fun unitStudentDao(): UnitStudentDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "database-name"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance

                }

                return instance
            }
        }
    }
}