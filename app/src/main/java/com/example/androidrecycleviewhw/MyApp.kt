package com.example.androidrecycleviewhw

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.widget.Toast

class MyApp : Application() {
    private var foregroundCount: Int = 0
    private var isBackground: Boolean = true

    override fun onCreate() {
        super.onCreate()
        foregroundCount = 0
        isBackground = true
        registerActivityLifecycle()
    }

    private fun registerActivityLifecycle() {
        this.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) = Unit

            override fun onActivityResumed(activity: Activity?) = Unit

            override fun onActivityStarted(activity: Activity?) {
                foregroundCount++
                if (isBackground) {
                    Toast.makeText(this@MyApp, "歡迎回來", Toast.LENGTH_SHORT).show()
                }
                isBackground = false
            }

            override fun onActivityDestroyed(activity: Activity?) = Unit

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) = Unit

            override fun onActivityStopped(activity: Activity?) {
                foregroundCount--
                isBackground = foregroundCount == 0
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) = Unit
        })
    }
}