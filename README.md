# KotlinRealmDemo
Realm Demo application using Kotlin

#  Installation
Add below dependancy in the project level's build.gradle
```gradle
buildscript {
    ext.kotlin_version = '1.2.10'
    dependencies {    
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath "io.realm:realm-gradle-plugin:5.3.0"
    }
}
```
Add below plugin in the application's build.gradle
```gradle
   apply plugin: 'kotlin-kapt'
   apply plugin: 'realm-android'
```
Add below dependancy in the application's build.gradle
```gradle
dependencies {    
    implementation"org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"       
}

```
Create custom application class and add below code snippet
```kotlin
import android.app.Application
import io.realm.Realm

class RealmApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}
```
Use below code snipet in AndroidManifest
```xml
<application
    android:allowBackup="true"
    android:name=".RealmApplication"
    android:icon="@mipmap/ic_launcher"
    android:label="@string/app_name"
    android:roundIcon="@mipmap/ic_launcher_round"
    android:supportsRtl="true"
    android:theme="@style/AppTheme">
    <activity android:name=".activity.MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />

            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
</application>
```
