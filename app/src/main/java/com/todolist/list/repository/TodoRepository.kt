package com.todolist.list.repository

import androidx.lifecycle.LiveData
import com.todolist.common.model.TodoDao
import com.todolist.common.model.TodoData
import com.todolist.list.endpoint.TodoApi
import io.reactivex.MaybeObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.Executors

/**
 * Class where network/database operation takes place.
 *
 * 1. Api service to get all todolist items.
 * 2. Store the items in db.
 *
 * @author Hari Hara Sudhan.N
 */
class TodoRepository (private val todoApi: TodoApi,
                      private val todoDao: TodoDao) {

    fun getTodoListsFromDB(): LiveData<List<TodoData>> {
        return todoDao.getTodoList()
    }

    fun getTodoListFromRemote() {
        todoApi.getTodoList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter { it.isNotEmpty() }
            .subscribe(object : MaybeObserver<ArrayList<TodoData>> {

                override fun onSuccess(todoList: ArrayList<TodoData>) {
                    Timber.d("Todo remote service is success.")
                    cacheInDatabase(todoList)
                }

                override fun onComplete() {
                    Timber.d("Observer method onComplete is called.")
                }

                override fun onSubscribe(d: Disposable) {
                    Timber.d("Todo list service is subscribed to a observer.")
                }

                override fun onError(error: Throwable) {
                    Timber.e(error, "Todo list service throws an error.")
                }
            })
    }

    private fun cacheInDatabase(todoList: ArrayList<TodoData>) {
        // Cannot update the DB in main thread, so created a background thread
        val executor = Executors.newFixedThreadPool(1)
        val worker = Runnable { todoDao.insertTodos(todoList) }
        executor.execute(worker)
    }
}