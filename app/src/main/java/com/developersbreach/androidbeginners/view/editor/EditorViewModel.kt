package com.developersbreach.androidbeginners.view.editor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.repository.StudentRepository
import kotlinx.coroutines.launch

class EditorViewModel(
    private val repository: StudentRepository
): ViewModel() {

    fun insertStudent(
        student: Student
    ) {
        viewModelScope.launch {
            repository.insertStudent(student)
        }
    }

    fun updateStudent(
        student: Student
    ) {
        viewModelScope.launch {
            repository.updateStudent(student)
        }
    }
}