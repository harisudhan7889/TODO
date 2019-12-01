package com.todolist.common.recyler;

/**
 * Callback for the click events.
 *
 * @author Hari Hara Sudhan.N
 */
public interface OnItemClickListener<T> {
    void onItemClicked(T item);
}
