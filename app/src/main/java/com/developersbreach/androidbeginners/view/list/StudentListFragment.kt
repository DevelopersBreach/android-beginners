package com.developersbreach.androidbeginners.view.list

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.androidbeginners.*
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.repository.StudentRepository


class StudentListFragment : Fragment() {

    private lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val application: Application = requireActivity().application
        val repository: StudentRepository = (application as StudentsApplication).repository
        val factory = StudentViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(StudentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editStudent = view.findViewById<EditText>(R.id.edit_student)
        val button = view.findViewById<Button>(R.id.button_save)
        val recyclerView: RecyclerView = view.findViewById(R.id.students_recycler_view)

        val adapter = StudentsAdapter(listener)
        recyclerView.adapter = adapter

        viewModel.studentsList.observe(viewLifecycleOwner, { students ->
            adapter.submitList(students)
        })

        button.setOnClickListener {
            val studentName = editStudent.text.toString()
            viewModel.insertStudent(Student(studentName))
            editStudent.setText("")
        }
    }

    private val listener = StudentsAdapter.OnClickListener { student ->
        findNavController().navigate(
            StudentListFragmentDirections.listToDetailFragment(student)
        )
    }
}