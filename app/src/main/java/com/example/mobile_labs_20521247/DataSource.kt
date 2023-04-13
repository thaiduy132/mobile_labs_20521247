package com.example.mobile_labs_20521247

class DataSource {
    // Add some dummy datas
    var empList : ArrayList<Employee> = arrayListOf(
        Employee(
            name ="Duy",
            salary = 24000000,
        ),
        Employee(
            name ="Duy dep trai",
            salary = 16000000,
        ),
        Employee(
            name ="Duy ko ngu",
            salary = 5000000,
        ),
        Employee(
            name ="Duy pro vai",
            salary = 9000000,
        ),
    )

    fun addEmployee(newEmployee: Employee){
        empList.add(newEmployee)
    }



}