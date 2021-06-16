package com.developersbreach.androidbeginners.repository

import androidx.annotation.WorkerThread
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.repository.database.StudentDao
import kotlinx.coroutines.flow.Flow

class StudentRepository(
    private val dao: StudentDao
) {

    val studentsList: Flow<List<Student>> = dao.getStudentsByOrder()

    @WorkerThread
    suspend fun insertStudent(
        student: Student
    ) {
        dao.insert(student)
    }
}