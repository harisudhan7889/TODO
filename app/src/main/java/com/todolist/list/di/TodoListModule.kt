package com.todolist.list.di

import com.todolist.BuildConfig
import com.todolist.common.di.ConvertorModule
import com.todolist.list.endpoint.TodoApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Hari Hara Sudhan.N
 */
@Module(includes = [ConvertorModule::class])
class TodoListModule {

    @TodoListActivityScope
    @Provides
    fun todoListApi(retrofit: Retrofit): TodoApi {
        return retrofit.create(TodoApi::class.java)
    }

    @TodoListActivityScope
    @Provides
    fun retrofit(gsonConverterFactory: GsonConverterFactory,
                 rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.TODO_BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }

}