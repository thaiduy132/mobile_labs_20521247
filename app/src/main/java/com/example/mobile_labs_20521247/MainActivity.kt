package com.example.mobile_labs_20521247

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import com.example.mobile_labs_20521247.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var A = Employee();
        A.salary = 20000000

        binding.button.setOnClickListener{
            A.name = binding.editTextTextPersonName.text.toString()
            Log.d("dede","${A.name} co luong ${A.calculateGrossSalary()}")
            binding.textView.text = A.name
        }



    }
}