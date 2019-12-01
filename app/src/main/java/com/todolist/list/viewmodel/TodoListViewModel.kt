package com.todolist.list.viewmodel

import androidx.lifecycle.LiveData
import com.todolist.common.viewmodel.TodoViewModel
import com.todolist.common.model.TodoData
import com.todolist.list.repository.TodoRepository

/**
 * @author Hari Hara Sudhan.N
 */
class TodoListViewModel(private val todoRepository: TodoRepository)
    : TodoViewModel() {

    private var liveData: LiveData<List<TodoData>>? = null

    override fun getTodoListFromDB(): LiveData<List<TodoData>> {
        if (null == liveData) {
            liveData = todoRepository.getTodoListsFromDB()
        }
        return liveData!!
    }

    override fun getTodoListFromRemote() {
        todoRepository.getTodoListFromRemote()
    }
}