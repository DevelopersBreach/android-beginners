package com.developersbreach.androidbeginners.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.utils.DATABASE_STUDENTS

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {

        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(
            context: Context
        ): StudentDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    DATABASE_STUDENTS
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}