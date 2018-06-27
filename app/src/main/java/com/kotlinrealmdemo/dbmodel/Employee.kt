package com.kotlinrealmdemo.dbmodel

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * by default kotlin class is final therefore declare it with open annotation
 * to allow to create the object
 */
open class Employee(
    @PrimaryKey open var _ID: Long = 0,
    open var sex: String = "",
    open var firstName: String = "",
    open var lastName: String = "" )
: RealmObject() {
}