package com.realmkotlinexample.dbservice


import com.kotlinrealmdemo.dbservice.EmployeeInterface
import com.kotlinrealmdemo.dbmodel.Employee
import io.realm.Realm
import io.realm.RealmResults


class EmployeeService : EmployeeInterface {

    override fun getEmployees(realm: Realm): RealmResults<Employee> {
        return realm.where(Employee::class.java).findAll()
    }

    override fun addOrUpdateEmployee(realm: Realm, employee: Employee): Boolean {
        try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(employee)
            realm.commitTransaction()
            return true
        } catch (e: Exception) {
            return false
        }
    }

    override fun getEmployee(realm: Realm, employeeId: Long): Employee {
        return realm.where(Employee::class.java).equalTo("_ID", employeeId).findFirst()!!
    }

    override fun deleteEmployee(realm: Realm, employee: Employee): Boolean {
        try {
            realm.beginTransaction()
            employee.deleteFromRealm()
            realm.commitTransaction()
            return true
        } catch (e: Exception) {
            return false
        }
    }

    override fun removeLastEmployee(realm: Realm) {
        realm.beginTransaction()
        getLastEmployee(realm).deleteFromRealm()
        realm.commitTransaction()
    }

    fun getLastEmployee(realm: Realm): Employee {
        return realm.where(Employee::class.java).findAll().last()!!
    }

    fun getNextPrimaryKey(realm: Realm): Long {
        var number: Number? = realm.where(Employee::class.java).max("_ID")
        var nextkey: Long = 1
        if(number != null) {
            nextkey = number!!.toLong() + 1
        }
        return  nextkey
    }
}