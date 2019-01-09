package com.nhahv.managermoney

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
open class BaseRecyclerViewAdapter<T, VH : BaseViewHolder<T>>(
    compare: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(compare) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return BaseViewHolder.create<T>(parent, R.layout.item_wedding) as VH
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it, position)
        }
    }
}

open class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    open fun bind(item: T, position: Int) {

    }

    companion object {
        private var inflater: LayoutInflater? = null
        fun <T> create(parent: ViewGroup, @LayoutRes resLayout: Int): BaseViewHolder<T> {
            if (inflater == null) {
                inflater = LayoutInflater.from(parent.context)
            }
            return BaseViewHolder(inflater!!.inflate(resLayout, parent, false))
        }
    }
}