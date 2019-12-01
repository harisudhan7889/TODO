package com.todolist.list.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.todolist.R
import com.todolist.common.extension.setStrikeThroughText
import com.todolist.common.model.TodoData
import kotlinx.android.synthetic.main.view_todo_item.view.*

/**
 * @author Hari Hara Sudhan.N
 */
class TodoView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_todo_item, this, true)
    }

    fun bind(todoData: TodoData?) {
        todoData?.let {
            val textValue = it.title ?: context.resources.getText(R.string.todo_no_title).toString()
            if (it.completionStatus == true) {
                todoTitle.setStrikeThroughText(textValue, 0)
                todoStatusImage.background = context.getDrawable(R.drawable.ic_todo_complete)
            } else {
                todoTitle.text = textValue
                todoStatusImage.background = context.getDrawable(R.drawable.ic_todo_progress)
            }
        }
    }
}