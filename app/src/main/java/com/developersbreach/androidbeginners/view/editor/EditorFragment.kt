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
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.repository.StudentRepository
import com.developersbreach.androidbeginners.utils.sportsList
import com.google.android.material.textfield.TextInputLayout

class EditorFragment : Fragment() {

    private lateinit var viewModel: EditorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val studentArgs = EditorFragmentArgs.fromBundle(requireArguments()).studentEditArgs
        val application: Application = requireActivity().application
        val repository: StudentRepository = (application as StudentsApplication).repository
        val factory = EditorViewModelFactory(repository, studentArgs)
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

        val inputStudentId =
            view.findViewById<TextInputLayout>(R.id.student_roll_number_input_layout)
        val inputStudentName = view.findViewById<TextInputLayout>(R.id.student_name_input_layout)
        val inputStudentSport = view.findViewById<TextInputLayout>(R.id.student_sport_input_layout)
        val saveButton = view.findViewById<Button>(R.id.button_save)

        val adapter = ArrayAdapter(requireContext(), R.layout.item_auto_complete_sport, sportsList)
        val autoCompleteTextView = inputStudentSport.editText as? AutoCompleteTextView
        autoCompleteTextView?.setAdapter(adapter)

        if (viewModel.studentArgs?.name?.length == null) {

            // Empty - New Student Entry
            saveButton.text = resources.getString(R.string.add_new_student)

            saveButton.setOnClickListener {
                val rollNumber: Int = inputStudentId.editText?.text.toString().toInt()
                val name = inputStudentName.editText?.text.toString()
                val favouriteSport = inputStudentSport.editText?.text.toString()

                viewModel.insertStudent(Student(rollNumber, name, favouriteSport))
                findNavController().navigateUp()
            }

        } else {
            // Not Empty - Updating Student Entry
            saveButton.text = resources.getString(R.string.update_existing_student)

            inputStudentId.editText?.setText(viewModel.studentArgs?.studentId.toString())
            inputStudentName.editText?.setText(viewModel.studentArgs?.name)
            inputStudentSport.editText?.setText(viewModel.studentArgs?.favoriteSport)

            saveButton.setOnClickListener {
                val rollNumber: Int = inputStudentId.editText?.text.toString().toInt()
                val name = inputStudentName.editText?.text.toString()
                val favouriteSport = inputStudentSport.editText?.text.toString()

                viewModel.updateStudent(Student(rollNumber, name, favouriteSport))
                findNavController().navigateUp()
            }
        }
    }
}