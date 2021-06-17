package com.developersbreach.androidbeginners.view.editor

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.developersbreach.androidbeginners.R
import com.developersbreach.androidbeginners.StudentsApplication
import com.developersbreach.androidbeginners.model.Sport
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.repository.StudentRepository
import com.google.android.material.textfield.TextInputLayout

class EditorFragment : Fragment() {

    private lateinit var viewModel: EditorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val application: Application = requireActivity().application
        val repository: StudentRepository = (application as StudentsApplication).repository
        val factory = EditorViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(EditorViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.editor_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputStudentName = view.findViewById<TextInputLayout>(R.id.student_name_input_layout)
        val inputStudentSport = view.findViewById<TextInputLayout>(R.id.student_sport_input_layout)
        val saveButton = view.findViewById<Button>(R.id.button_save)

        saveButton.setOnClickListener {
            val studentName = inputStudentName.editText?.text.toString()
            viewModel.insertStudent(Student(studentName))
            inputStudentName.editText?.setText("")
            findNavController().navigateUp()
        }

        val sportList = Sport.sportsList
        val adapter = ArrayAdapter(requireContext(), R.layout.item_auto_complete_sport, R.id.item_sport_title, sportList)
        (inputStudentSport.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }
}