package com.developersbreach.androidbeginners.view.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.repository.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(
    private val repository: StudentRepository
): ViewModel() {

    val studentsList: LiveData<List<Student>> = repository.studentsList.asLiveData()

    fun insertStudent(
        student: Student
    ) {
        viewModelScope.launch {
            repository.insertStudent(student)
        }
    }
}