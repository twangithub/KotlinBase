package com.twan.kotlinbase.widgets.router

import android.app.Activity

interface RouterCallback {
    fun onBefore(from: Activity, to: Class<*>)
    fun onNext(from: Activity, to: Class<*>)
    fun onError(from: Activity, to: Class<*>, throwable: Throwable)
}