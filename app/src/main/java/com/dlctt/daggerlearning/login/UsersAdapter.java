package com.dlctt.daggerlearning.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.dlctt.daggerlearning.R;
import com.dlctt.daggerlearning.model.pojo.User;

public class UsersAdapter extends ListAdapter<User, UsersAdapter.UserViewHolder>
{
    UsersAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback)
    {
        super(diffCallback);
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.user_item_layout, parent, false);
        return new UserViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position)
    {
        holder.bind(getItem(position));
    }

    class UserViewHolder extends RecyclerView.ViewHolder
    {
        TextView userInfoText;

        UserViewHolder(View itemView)
        {
            super(itemView);
            userInfoText = itemView.findViewById(R.id.user_info_text);
        }

        void bind(User item)
        {
            userInfoText.setText(item.toString());
        }
    }
}
