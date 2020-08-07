package com.twan.kotlinbase.app

import android.app.Activity
import android.app.Application
import android.os.Process
import rxhttp.wrapper.param.RxHttp
import kotlin.system.exitProcess

class App : Application() {

    private var allActivities = mutableSetOf<Activity>()

    companion object {
        private lateinit var appInstance: App

        @Synchronized
        @JvmStatic
        fun getInstance(): App {
            return appInstance
        }

    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
        RxHttp.setDebug(true)
    }

    fun addActivity(act: Activity) {
        allActivities.add(act)
    }

    fun removeActivity(act: Activity?) {
        if (allActivities != null) {
            allActivities.remove(act)
        }
    }

    fun exitApp() {
        if (allActivities != null) {
            synchronized(allActivities) {
                for (act in allActivities) {
                    act.finish()
                }
            }
        }
        Process.killProcess(Process.myPid())
        exitProcess(0)
    }
}