package com.example.mobile_labs_20521247

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_labs_20521247.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private  var dataSource = DataSource()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = EmployeeAdapter(dataSource.empList)
        binding.rvEmployees.adapter = adapter
        binding.rvEmployees.layoutManager = LinearLayoutManager(this)
        binding.button.setOnClickListener{
            var empName = binding.editTextTextPersonName.text.toString()
            var empSalary = binding.editTextTextPersonName2.text.toString()
            if(empName == "" || empSalary == ""){
                Toast.makeText(this@MainActivity,"Please enter all fields",Toast.LENGTH_SHORT).show()
            }
            else {
                dataSource.empList.add(
                    Employee(
                    name =empName,
                    salary = empSalary.toInt(),
                    )
                )
                adapter.notifyDataSetChanged()
                clearField()
            }
        }


    }

    fun clearField(){
        binding.editTextTextPersonName.text = null
        binding.editTextTextPersonName2.text = null

    }
}