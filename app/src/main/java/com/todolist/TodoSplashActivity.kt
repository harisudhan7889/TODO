package com.todolist

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.todolist.list.ui.TodoListActivity


/**
 * @author Hari Hara Sudhan.N
 */
class TodoSplashActivity : AppCompatActivity() {

    companion object {
        private const val WAIT_TIME: Long = 5000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(TodoListActivity.getIntent(this))
            finish()
        }, WAIT_TIME)
    }
}