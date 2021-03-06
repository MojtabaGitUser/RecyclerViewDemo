package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*


class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private val studentList: ArrayList<Student> = ArrayList<Student>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        viewHolder.setData(student)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun updateData(newStudentList: List<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
    }

    class StudentViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(student: Student) {
            itemView.apply {
                tvName.text = student.name
                tvAge.text = "${student.age}"
                tvAddress.text = student.address
            }
        }
    }
}