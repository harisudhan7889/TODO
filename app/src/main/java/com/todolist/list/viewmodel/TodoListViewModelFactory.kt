package com.todolist.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.todolist.list.repository.TodoRepository

/**
 * @author Hari Hara Sudhan.N
 */
class TodoListViewModelFactory(private val todoRepository: TodoRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TodoListViewModel::class.java)) {
            TodoListViewModel(todoRepository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel")
        }
    }
}