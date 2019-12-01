package com.todolist.common.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * @author Hari Hara Sudhan.N
 */
@Parcelize
@Entity(tableName = "tododata")
data class TodoData (@PrimaryKey @ColumnInfo(name = "id") val id: Int,
                     @ColumnInfo(name = "title")
                     var title: String?,
                     @ColumnInfo(name = "status")
                     @SerializedName("completed")
                     var completionStatus: Boolean?): Parcelable