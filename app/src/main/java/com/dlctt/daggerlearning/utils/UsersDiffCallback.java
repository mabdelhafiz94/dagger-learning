package com.dlctt.daggerlearning.utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.dlctt.daggerlearning.model.pojo.User;

public class UsersDiffCallback extends DiffUtil.ItemCallback<User>
{
    @Override
    public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem)
    {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem)
    {
        return oldItem.getId() == newItem.getId();
    }
}
