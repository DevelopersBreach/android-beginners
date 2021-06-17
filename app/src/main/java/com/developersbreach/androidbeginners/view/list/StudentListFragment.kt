package com.developersbreach.androidbeginners.view.list

import android.app.Application
import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.androidbeginners.R
import com.developersbreach.androidbeginners.StudentsApplication
import com.developersbreach.androidbeginners.repository.StudentRepository
import kotlinx.android.synthetic.main.fragment_student_list.*


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

        setHasOptionsMenu(true)

        val recyclerView: RecyclerView = view.findViewById(R.id.students_recycler_view)
        val adapter = StudentsAdapter(clickListener, longClickListener)
        recyclerView.adapter = adapter

        viewModel.studentsList.observe(viewLifecycleOwner, { students ->
            adapter.submitList(students)
        })

        fab_new_student.setOnClickListener {
            findNavController().navigate(
                StudentListFragmentDirections.listToEditorFragment()
            )
        }

        val itemTouchHelper = ItemTouchHelper(helper)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_delete, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete_all_students_menu) {
            viewModel.deleteAllStudents()
        }

        return super.onOptionsItemSelected(item)
    }

    private val clickListener = StudentsAdapter.OnClickListener { student ->
        findNavController().navigate(
            StudentListFragmentDirections.listToDetailFragment(student)
        )
    }

    private val longClickListener = StudentsAdapter.OnLongClickListener { student ->
        viewModel.deleteStudent(student)
    }

    private val helper = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val studentId: Int = viewHolder.adapterPosition
            viewModel.deleteStudentById(studentId)
        }

        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            val itemView = viewHolder.itemView
            val candyColor = ContextCompat.getColor(requireContext(), R.color.candy)
            val background = ColorDrawable(candyColor)

            if (dX < 0) {
                background.setBounds(
                    itemView.right + dX.toInt(),
                    itemView.top, itemView.right, itemView.bottom
                )
            }

            background.draw(c)
        }
    }
}