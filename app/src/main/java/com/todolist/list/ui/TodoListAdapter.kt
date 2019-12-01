package com.todolist.list.ui

import android.content.Context
import android.view.ViewGroup
import com.todolist.R
import com.todolist.common.model.TodoData
import com.todolist.common.recyler.BaseRvAdapter
import com.todolist.common.recyler.OnItemClickListener

/**
 * @author Hari Hara Sudhan.N
 */
class TodoListAdapter(context: Context):
    BaseRvAdapter<TodoData, OnItemClickListener<TodoData>, TodoViewHolder>(context){
    /**
     * To be implemented in as specific adapter
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(inflate(R.layout.view_todo_row, parent) as? TodoView)
    }
}