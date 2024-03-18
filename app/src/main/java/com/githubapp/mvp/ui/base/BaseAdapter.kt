package com.githubapp.mvp.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<I, VH: RecyclerView.ViewHolder> :  RecyclerView.Adapter<VH>(){
    var items: ArrayList<I> = ArrayList()

    fun addItems(items: List<I>){
        this.items.addAll(items)
        notifyItemRangeInserted(itemCount - items.size,
                itemCount)
    }

    fun clearItems(){
        this.items.clear()
        notifyDataSetChanged()
    }
}