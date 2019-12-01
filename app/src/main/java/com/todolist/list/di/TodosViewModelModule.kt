package com.todolist.list.di

import android.content.Context
import com.todolist.common.TodoDatabase
import com.todolist.common.di.ContextModule
import com.todolist.common.model.TodoDao
import com.todolist.list.endpoint.TodoApi
import com.todolist.list.repository.TodoRepository
import com.todolist.list.viewmodel.TodoListViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * @author Hari Hara Sudhan.N
 */
@Module(includes = [TodoListModule::class, ContextModule::class])
class TodosViewModelModule {

    @TodoListActivityScope
    @Provides
    fun todoListRepository(todoApi: TodoApi, todoDao: TodoDao): TodoRepository {
        return TodoRepository(todoApi, todoDao)
    }

    @TodoListActivityScope
    @Provides
    fun todoListDao(context: Context): TodoDao {
        return TodoDatabase.getInstance(context).todoDao()
    }

    @TodoListActivityScope
    @Provides
    fun todoListViewModelFactory(todoRepository: TodoRepository): TodoListViewModelFactory {
        return TodoListViewModelFactory(todoRepository)
    }
}