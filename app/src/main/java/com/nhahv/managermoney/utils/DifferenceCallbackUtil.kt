package com.nhahv.managermoney.utils

import androidx.recyclerview.widget.DiffUtil
import com.nhahv.managermoney.data.model.UserWedding

class UserWedCallback : DiffUtil.ItemCallback<UserWedding>() {
    override fun areItemsTheSame(oldItem: UserWedding, newItem: UserWedding) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: UserWedding, newItem: UserWedding) = oldItem == newItem
}