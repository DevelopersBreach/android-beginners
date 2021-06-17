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

    @WorkerThread
    suspend fun updateStudent(
        student: Student
    ) {
        dao.update(student)
    }

    @WorkerThread
    suspend fun deleteSelectedStudent(
        student: Student
    ) {
        dao.deleteSingleStudent(student)
    }

    @WorkerThread
    suspend fun deleteAllStudents() {
        dao.deleteAllStudents()
    }

    @WorkerThread
    suspend fun deleteSelectedStudentById(
        studentId: Int
    ) {
        val list: List<Student> = dao.getStudents()
        val student: Student = list[studentId]
        dao.deleteSingleStudent(student)
    }
}