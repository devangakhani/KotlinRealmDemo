package com.kotlinrealmdemo.activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.kotlinrealmdemo.R
import com.kotlinrealmdemo.dbmodel.Employee
import com.realmkotlinexample.dbservice.EmployeeService
import io.realm.Realm

class MainActivity : Activity() {
    companion object {
        const val TAG: String = "MainActivity"
    }
    private lateinit var employeeService: EmployeeService
    private lateinit var realm: Realm
    private lateinit var tvEmployeeData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvEmployeeData = findViewById(R.id.tvEmployeeData)

        try {

            employeeService = EmployeeService()
            realm = Realm.getDefaultInstance()
            var employeeModel = Employee(employeeService.getNextPrimaryKey(realm),"Male", "Devang", "Akhani")

            employeeService.addOrUpdateEmployee(realm, employeeModel)

            tvEmployeeData.setText(""+employeeService.getLastEmployee(realm))

            employeeModel = employeeService.getEmployee(realm, employeeModel._ID)

            employeeModel = Employee(employeeModel._ID, employeeModel.sex, employeeModel.firstName, "thakker")

            employeeService.addOrUpdateEmployee(realm, employeeModel)

            tvEmployeeData.setText(tvEmployeeData.text.toString()+ "\n"  + employeeService.getLastEmployee(realm))

        } catch (e: Exception) {
            Log.e(TAG, "Exception in creating realm object:", e)
        }
    }
}
