package com.todolist.common.di

import android.content.Context
import com.todolist.common.ui.BaseActivity
import dagger.Module
import dagger.Provides

/**
 * Module which provides the context.
 *
 * @author Hari Hara Sudhan.N
 */
@Module
class ContextModule(private val context: Context) {
    @Provides
    fun context(): Context {
        return context.applicationContext
    }

    @Provides
    fun activity(): BaseActivity {
        return context as BaseActivity
    }
}