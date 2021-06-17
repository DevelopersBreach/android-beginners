package com.developersbreach.androidbeginners.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.androidbeginners.R
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.view.list.StudentsAdapter.*

class StudentsAdapter(
    private val clickListener: OnClickListener,
    private val longClickListener: OnLongClickListener
) : ListAdapter<Student, StudentViewHolder>(StudentsDiffUtils()) {

    class StudentViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.item_student_name_text_view)

        fun bind(
            student: Student,
            clickListener: OnClickListener,
            longClickListener: OnLongClickListener
        ) {
            name.text = student.name
            name.setOnClickListener {
                clickListener.onStudentItemClick(student)
            }

            name.setOnLongClickListener {
                longClickListener.onStudentItemLongClick(student)
                true
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): StudentViewHolder {
        return StudentViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_student, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student: Student = getItem(position)
        holder.bind(student, clickListener, longClickListener)
    }

    class StudentsDiffUtils : DiffUtil.ItemCallback<Student>() {

        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.name == newItem.name
        }
    }

    class OnClickListener(val clickListener: (student: Student) -> Unit) {

        fun onStudentItemClick(student: Student) {
            clickListener(student)
        }
    }

    class OnLongClickListener(val longClickListener: (student: Student) -> Unit) {

        fun onStudentItemLongClick(student: Student) {
            longClickListener(student)
        }
    }
}