package com.todolist.list.di

import com.todolist.list.ui.TodoListActivity
import dagger.Component

/**
 * @author Hari Hara Sudhan.N
 */
@TodoListActivityScope
@Component(modules = [TodosViewModelModule::class])
interface TodoListComponent {
    fun inject(todoListActivity: TodoListActivity)
}