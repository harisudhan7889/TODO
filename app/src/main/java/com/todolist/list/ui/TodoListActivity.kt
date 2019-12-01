package com.todolist.list.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.todolist.R
import com.todolist.common.di.ContextModule
import com.todolist.common.model.TodoData
import com.todolist.common.recyler.CustomDividerDecorator
import com.todolist.common.recyler.OnItemClickListener
import com.todolist.common.ui.BaseActivity
import com.todolist.common.viewmodel.TodoViewModel
import com.todolist.list.di.DaggerTodoListComponent
import kotlinx.android.synthetic.main.activity_todo_list.*
import javax.inject.Inject

/**
 * @author Hari Hara Sudhan.N
 */
class TodoListActivity : BaseActivity(), OnItemClickListener<TodoData> {

    @Inject
    lateinit var todoListViewModel: TodoViewModel
    private var todoListAdapter: TodoListAdapter? = null

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, TodoListActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)
        initViews()
        injectDependency()
        addLiveDataListener()
    }

    override fun onResume() {
        super.onResume()
        todoListViewModel.getTodoListFromRemote()
    }

    override fun onItemClicked(item: TodoData?) {
        //TODO: Yet to be handled in future
    }

    private fun initViews() {
        initActionBar()
        todoListAdapter = TodoListAdapter(this)
        todoListAdapter!!.setItemClickListener(this)
        val divider = CustomDividerDecorator(this)
        divider.setMargins(resources.getDimensionPixelOffset(R.dimen.todo_divider_margin_left), 0,
            resources.getDimensionPixelOffset(R.dimen.todo_divider_margin_right), 0)
        todoList.apply {
            layoutManager = LinearLayoutManager(this@TodoListActivity)
            addItemDecoration(divider)
            adapter = todoListAdapter
        }
    }

    /**
     * Intializes the action bar.
     */
    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            title = resources.getString(R.string.app_name)
            it.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun injectDependency() {
        val launchListComponent
                = DaggerTodoListComponent.builder().contextModule(ContextModule(this)).build()
        launchListComponent.inject(this)
    }

    /**
     * Room Db live data listener.
     */
    private fun addLiveDataListener() {
        todoListViewModel
            .getTodoListFromDB()
            .observe(this, Observer<List<TodoData>> { todoList ->
                if(todoList?.isNotEmpty() == true) {
                    todoListAdapter?.setItems(todoList as? ArrayList<TodoData>)
                }
            })
    }
}
