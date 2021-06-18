package com.developersbreach.androidbeginners.view.editor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.repository.StudentRepository

class EditorViewModelFactory(
    private val repository: StudentRepository,
    private val studentArgs: Student?
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EditorViewModel(repository, studentArgs) as T
        }

        throw IllegalArgumentException("Unknown EditorViewModel Class")
    }
}