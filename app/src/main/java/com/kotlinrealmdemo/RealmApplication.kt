package com.kotlinrealmdemo

import android.app.Application
import android.util.Log
import io.realm.Realm

class RealmApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        try {

            Realm.init(this)

        } catch (e: Exception) {
            Log.e("DevangTest", "Exception in creating realm object", e)
        }

    }
}