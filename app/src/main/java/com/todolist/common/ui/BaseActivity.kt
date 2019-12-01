package com.todolist.common.ui

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

/**
 * @author Hari Hara Sudhan.N
 */
open class BaseActivity: AppCompatActivity() {
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var isEventHandled = false
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                isEventHandled = true
            }
        }
        return isEventHandled || super.onOptionsItemSelected(item)
    }
}