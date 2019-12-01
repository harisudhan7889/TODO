package com.todolist.common.extension

import android.text.Spannable
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.widget.TextView

/**
 * @author Hari Hara Sudhan.N
 */
fun TextView.setStrikeThroughText(textValue: String, start: Int, length: Int = textValue.length) {
    setText(textValue, TextView.BufferType.SPANNABLE)
    val strikeThroughSpan = text as Spannable
    strikeThroughSpan.setSpan(StrikethroughSpan(), start, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
}