package com.todolist.common.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

/**
 * @author Hari Hara Sudhan.N
 */
@Dao
interface TodoDao {

    @Query("Select * From tododata")
    fun getTodoList(): LiveData<List<TodoData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodos(todoList: List<TodoData>)

    /**
     * Delete the data from database.
     */
    @Query("DELETE FROM tododata")
    fun deleteAllTodoItems()

    /**
     * Gets the count of database entry for the todos.
     */
    @Query("SELECT COUNT(id) FROM tododata")
    fun getTodoItemsCount(): Single<Int>
}