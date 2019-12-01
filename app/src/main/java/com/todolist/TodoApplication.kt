package com.todolist

import android.app.Application
import timber.log.Timber

/**
 * @author Hari Hara Sudhan.N
 */
class TodoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}