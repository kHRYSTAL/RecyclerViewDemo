package me.khrystal.recyclerviewdemo;

import android.view.View;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/4/28
 * update time:
 * email: 723526676@qq.com
 */
public interface OnItemClickListener<T> {
    void onItemClick(T data,View view, int position);
    void onItemLongClick(T data,View view, int position);
}
