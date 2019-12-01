package com.todolist.list.endpoint

import com.todolist.common.model.TodoData
import io.reactivex.Maybe
import retrofit2.http.GET

/**
 * @author Hari Hara Sudhan.N
 */
interface TodoApi {
    /**
     * Get all todolists.
     */
    @GET("todos")
    fun getTodoList(): Maybe<ArrayList<TodoData>>
}