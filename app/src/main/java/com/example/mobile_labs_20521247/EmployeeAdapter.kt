package com.example.mobile_labs_20521247

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.mobile_labs_20521247.databinding.ItemEmployeeBinding

class EmployeeAdapter(
    // Data source of employees to adapt it to View
    var employees : ArrayList<Employee>
    // Because we are using RecyclerView so we need to extends from it
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>(){

    // This class take an itemView as a parameter, which is a View,
    // to refers it
    inner class EmployeeViewHolder(val binding: ItemEmployeeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEmployeeBinding.inflate(layoutInflater, parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.binding.apply {
            tvEmployeeGrossSalary.text = employees[position].calculateGrossSalary().toString()
            tvEmployeeName.text = employees[position].name.toString()
            tvEmployeeSalary.text = employees[position].salary.toString()
        }
    }

    override fun getItemCount(): Int {
        return employees.size
    }

}