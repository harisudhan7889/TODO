package com.todolist.list.ui

import com.todolist.common.model.TodoData
import com.todolist.common.recyler.BaseViewHolder
import com.todolist.common.recyler.OnItemClickListener

/**
 * @author Hari Hara Sudhan.N
 */
class TodoViewHolder(private val todoView:TodoView?)
    : BaseViewHolder<TodoData, OnItemClickListener<TodoData>>(todoView) {
    override fun onBind(todoData: TodoData?, listener: OnItemClickListener<TodoData>?) {
        todoView?.bind(todoData)
        todoView?.setOnClickListener { listener?.onItemClicked(todoData) }
    }
}