package com.developersbreach.androidbeginners

import android.app.Application
import com.developersbreach.androidbeginners.repository.StudentRepository
import com.developersbreach.androidbeginners.repository.database.StudentDatabase

class StudentsApplication : Application() {

    private val database by lazy {
        StudentDatabase.getDatabase(this)
    }

    val repository by lazy {
        StudentRepository(database.studentDao())
    }
}