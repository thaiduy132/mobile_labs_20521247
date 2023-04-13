package com.example.mobile_labs_20521247

import android.util.Log

class Employee(
    val dependentCost : Int = 11000000,
    var name : String,
    var salary : Int,
){
     fun printInfo() {
        Log.i("Test","$name co luong ${calculateGrossSalary()}")
    }
    fun calculateGrossSalary() : Double{
        var gross = 0
        if(salary != null) {
            gross = salary as Int
        }
        var temp : Double = gross * (1 - 0.105)
        if (temp <= dependentCost) return temp
        return dependentCost + (temp - dependentCost)*(1 - 0.05)
    }


}