package com.todolist.common.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.todolist.common.model.TodoData

/**
 * @author Hari Hara Sudhan.N
 */
abstract class TodoViewModel: ViewModel() {
    abstract fun getTodoListFromDB(): LiveData<List<TodoData>>
    abstract fun getTodoListFromRemote()
}