package com.developersbreach.androidbeginners.view.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.repository.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class StudentViewModel(
    val repository: StudentRepository
) : ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob())

    val studentsList: LiveData<List<Student>> = repository.studentsList.asLiveData()

    fun deleteStudent(
        student: Student
    ) {
        viewModelScope.launch {
            repository.deleteSelectedStudent(student)
        }
    }

    fun deleteAllStudents() {
        viewModelScope.launch {
            repository.deleteAllStudents()
        }
    }

    fun deleteStudentById(
        studentId: Int
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteSelectedStudentById(studentId)
        }
    }
}